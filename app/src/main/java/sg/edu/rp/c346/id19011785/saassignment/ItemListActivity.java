package sg.edu.rp.c346.id19011785.saassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {

    EditText prdName, prdExpiry;
    Button addB, updateB, deleteB;

    String fm;
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

        fm = String.format("Expires<%d-%d-%d> %s", prdExpiry.getText().toString(), prdName.getText().toString());

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}