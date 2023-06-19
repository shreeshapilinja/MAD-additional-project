package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    TextView t1;
    int i=1;
    Handler hd = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.bstart);
        b2 = findViewById(R.id.bstop);
        //b3 = findViewById(R.id.clear);
        t1 = findViewById(R.id.displaycount);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hd.postDelayed(updatetimer,1000);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hd.removeCallbacks(updatetimer);
            }
        });
    }
    private final Runnable updatetimer = new Runnable() {
        @Override
        public void run() {
            t1.setText(""+i);
            hd.postDelayed(this,1000);
            i++;
        }
    };
}