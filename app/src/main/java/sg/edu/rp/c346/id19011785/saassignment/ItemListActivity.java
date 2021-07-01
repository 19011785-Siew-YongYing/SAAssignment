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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {

    EditText prdName, prdExpiry, prdIndex;
    Button addB, updateB, deleteB;

    Spinner opts;

    ListView pdLists;
    ArrayList<String> alProducts;
    ArrayAdapter<String> aaProducts;

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
        alProducts.add("Expires<2022-11-10> iPhone 11");
        alProducts.add("Expires<2021-10-30> Acer Swift 3");
        alProducts.add("Expires<2021-7-30> Wireless Mouse");
        Collections.sort(alProducts);

        aaProducts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alProducts);
        pdLists.setAdapter(aaProducts);

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fm = String.format("Expires<%s> %s", prdExpiry.getText().toString(), prdName.getText().toString());
                alProducts.add(fm);
                aaProducts.notifyDataSetChanged();
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
                aaProducts.notifyDataSetChanged();
                Toast.makeText(ItemListActivity.this, "Product & Warranty Date Updated", Toast.LENGTH_SHORT).show();
            }
        });

        opts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0: // when '1 month' is selected (** Expiry date format - YYYY-M-D **)
                        break;

                    case 1: // when '3 month' is selected

                        break;

                    case 2: // when '6 month' is selected

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}