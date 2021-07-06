package sg.edu.rp.c346.id19011785.saassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ItemListActivity extends AppCompatActivity {

    EditText prdName, prdExpiry, prdIndex;
    Button addB, updateB, deleteB;

    Spinner opts;

    ListView pdLists;
    ArrayList<String> alProducts;
    ArrayAdapter<String> aaProducts;
    String[] name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        prdName = findViewById(R.id.editProductName);
        prdExpiry = findViewById(R.id.editExpiryDate);
        prdIndex = findViewById(R.id.editInd);

        addB = findViewById(R.id.addBtn);
        updateB = findViewById(R.id.updateBtn);
        deleteB = findViewById(R.id.deleteBtn);

        opts = findViewById(R.id.spinner);
        pdLists = findViewById(R.id.listViewProducts);
        alProducts = new ArrayList<String>();
        // adding at least 5 products into the list first ; for now 3
        // format = Expires<YYYY-M-D> Item Name
        alProducts.add(String.format("Expires<%s> %s", "2021-11-5", "iPhone 8"));
        alProducts.add(String.format("Expires<%s> %s", "2021-10-30", "Acer Swift 3")); // "Expires<2021-10-30> Acer Swift 3"
        alProducts.add(String.format("Expires<%s> %s", "2022-3-10", "iPhone 11")); //"Expires<2022-11-10> iPhone 11"
        alProducts.add(String.format("Expires<%s> %s", "2021-8-30", "Wireless Mouse")); // "Expires<2021-8-30> Wireless Mouse"
        alProducts.add(String.format("Expires<%s> %s", "2022-2-30", "Asus Vivobook S14"));

        aaProducts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alProducts);
        pdLists.setAdapter(aaProducts);

        class NComparator<T> implements Comparator<String> { //"Expires<[0-9]{4}\\W[0-9]{1,2}\\W[0-9]{1,2}> "
            private String getName(String s) {
                for (String name1 : alProducts) {
                    name = name1.split("[Expires<[0-9]{4}\\\\W[0-9]{1,2}\\\\W[0-9]{1,2}> ]");
                    String s1 = name[0];
                    s1 = s;
                }
                return s;
            }
            @Override
            public int compare(String o1, String o2) {
                return getName(o1).compareTo(getName(o2));
            }
        }
        Collections.sort(alProducts, new NComparator<String>());

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fm = String.format("Expires<%s> %s", prdExpiry.getText().toString(), prdName.getText().toString());
                alProducts.add(fm);
                aaProducts.notifyDataSetChanged();
                /*Collections.sort(alProducts, new NComparator<String>());*/
                Toast.makeText(ItemListActivity.this, "Product added!", Toast.LENGTH_SHORT).show();
            }
        });

        deleteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prdExpiry.setEnabled(false);
                prdName.setEnabled(false);
                int index = Integer.parseInt(prdIndex.getText().toString());
                alProducts.remove(index);
                aaProducts.notifyDataSetChanged();
                Toast.makeText(ItemListActivity.this, "Product removed", Toast.LENGTH_SHORT).show();
            }
        });

        updateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fm = String.format("Expires<%s> %s", prdExpiry.getText().toString(), prdName.getText().toString());
                int index = Integer.parseInt(prdIndex.getText().toString());
                alProducts.set(index, fm);
                /*Collections.sort(alProducts, new NComparator<String>());*/
                aaProducts.notifyDataSetChanged();
                Toast.makeText(ItemListActivity.this, "Product & Warranty Date Updated", Toast.LENGTH_SHORT).show();
            }
        });

        // Unable to work
        /*opts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int year = 0;
                int mth = 0;
                int day = 0;
                Calendar cal = Calendar.getInstance();
                for (int i = 0; i < alProducts.size(); i ++){
                    String conditions = "Expires<\\W>";
                    ex = alProducts.get(i).split(conditions);
                    for (int y = 0; y < ex.length; y ++){
                        year = Integer.parseInt(ex[0]);
                        mth = Integer.parseInt(ex[1]);
                        day = Integer.parseInt(ex[2]);
                    }
                }
                switch(position){
                    case 0: // for '1 month' selected
                        cal.add(Calendar.MONTH, 1);

                        break;
                    case 1: // for '3 month' selected
                        cal.add(Calendar.MONTH, 3);

                        break;

                    case 2: // for '6 month' selected
                        cal.add(Calendar.MONTH, 6);

                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }
}