package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;            // button objects
    EditText result;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b0 = (Button) findViewById(R.id.zero);
        b0.setOnClickListener((View.OnClickListener)this);

        b1 = (Button) findViewById(R.id.one);
        b1.setOnClickListener((View.OnClickListener)this);

        b2 = (Button) findViewById(R.id.two);
        b2.setOnClickListener((View.OnClickListener)this);

        b3 = (Button) findViewById(R.id.three);
        b3.setOnClickListener((View.OnClickListener)this);

        b4 = (Button) findViewById(R.id.four);
        b4.setOnClickListener((View.OnClickListener)this);

        b5 = (Button) findViewById(R.id.five);
        b5.setOnClickListener((View.OnClickListener)this);

        b6 = (Button) findViewById(R.id.six);
        b6.setOnClickListener((View.OnClickListener)this);

        b7 = (Button) findViewById(R.id.seven);
        b7.setOnClickListener((View.OnClickListener)this);

        b8 = (Button) findViewById(R.id.eight);
        b8.setOnClickListener((View.OnClickListener)this);

        b9 = (Button) findViewById(R.id.nine);
        b9.setOnClickListener((View.OnClickListener)this);

        b10 = (Button) findViewById(R.id.add);
        b10.setOnClickListener((View.OnClickListener)this);

        b11 = (Button) findViewById(R.id.sub);
        b11.setOnClickListener((View.OnClickListener)this);

        b12 = (Button) findViewById(R.id.mul);
        b12.setOnClickListener((View.OnClickListener)this);

        b13= (Button) findViewById(R.id.div);
        b13.setOnClickListener((View.OnClickListener)this);

        b14 = (Button) findViewById(R.id.dot);
        b14.setOnClickListener((View.OnClickListener)this);

        b15 = (Button) findViewById(R.id.clear);
        b15.setOnClickListener((View.OnClickListener)this);

        b16 = (Button) findViewById(R.id.equal);
        b16.setOnClickListener((View.OnClickListener)this);

        result = findViewById(R.id.res);
        result.setText("");
    }

    @Override
    public void onClick(View view) {
        if(view.equals(b0))
            result.append("0");

        if(view.equals(b1))
            result.append("1");

        if(view.equals(b2))
            result.append("2");

        if(view.equals(b3))
            result.append("3");

        if(view.equals(b4))
            result.append("4");

        if(view.equals(b5))
            result.append("5");

        if(view.equals(b6))
            result.append("6");

        if(view.equals(b7))
            result.append("7");

        if(view.equals(b8))
            result.append("8");

        if(view.equals(b9))
            result.append("9");

        if(view.equals(b10))
            result.append("+");

        if(view.equals(b11))
            result.append("-");

        if(view.equals(b12))
            result.append("*");

        if(view.equals(b13))
            result.append("/");

        if(view.equals(b14))
            result.append(".");

        if(view.equals(b15))
            result.setText("");

        if(view.equals(b16)){
            String data = result.getText().toString();
            if(data.contains("+")){
                String[] op = data.split("\\+");
                if(op.length==2){
                    double op1 = Double.parseDouble(op[0]);
                    double op2 = Double.parseDouble(op[1]);
                    double ans = op1+op2;
                    result.setText(""+ans);
                }
            }
            if(data.contains("-")){
                String[] op = data.split("-");
                if(op.length==2){
                    double op1 = Double.parseDouble(op[0]);
                    double op2 = Double.parseDouble(op[1]);
                    double ans = op1-op2;
                    result.setText(""+ans);
                }
            }
            if(data.contains("*")){
                String[] op = data.split("\\*");
                if(op.length==2){
                    double op1 = Double.parseDouble(op[0]);
                    double op2 = Double.parseDouble(op[1]);
                    double ans = op1*op2;
                    result.setText(""+ans);
                }
            }
            if(data.contains("/")){
                String[] op = data.split("/");
                if(op.length==2){
                    double op1 = Double.parseDouble(op[0]);
                    double op2 = Double.parseDouble(op[1]);
                    double ans = op1/op2;
                    result.setText(""+ans);
                }
            }
        }
    }
}