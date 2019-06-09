package hjddevs.spotlightsandspotholes.com.spotlightsandspotholes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        String text = intent.getStringExtra(LocationFetchTest.EXTRA_TEXT);
        //int number = intent.getIntExtra(LocationFetchTest.EXTRA_NUMBER, 0);

        TextView textView1 = (TextView) findViewById(R.id.textview1);
        //  TextView textView2 = (TextView) findViewById(R.id.textview2);

        textView1.setText(text);
        //   textView2.setText("" + number);
    }
}
