package sg.edu.rp.c346.id19011785.saassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
        pic.setImageResource(R.drawable.listpic);

        header.setText(getString(R.string.heading));
        intro.setText(getString(R.string.intro));

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(int1);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.githubpage)));
                startActivity(int2);
            }
        });

    }
}