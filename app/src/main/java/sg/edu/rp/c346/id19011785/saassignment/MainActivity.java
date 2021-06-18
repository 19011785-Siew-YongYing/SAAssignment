package sg.edu.rp.c346.id19011785.saassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnList, btnWeb;
    TextView header, intro;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnList = findViewById(R.id.btnProceed);
        btnWeb = findViewById(R.id.btnGH);
        header = findViewById(R.id.heading);
        intro = findViewById(R.id.intro);
        pic = findViewById(R.id.image1);

        header.setText("Product and Warranty Tracker");
        intro.setText("Hello, welcome to 'Product and Warranty Tracker'. \nBy using this app, you will get to take note of \n" +
                "your products' warranty. You can also add, delete and even update on \nyour products' warranty :). \n Click on the following buttons to:" +
                "\n1.: Access the list of products (1st button) \n2.: The codes for this app on GitHub (2nd button) ");

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}