package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class login extends AppCompatActivity {
    EditText ed3,ed4;
    Button b2;
    int Counter=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed3 = findViewById(R.id.txt3);
        ed4 = findViewById(R.id.txt4);
        b2 = (Button) findViewById(R.id.button2);
        String reguser,redpwd;
        reguser = getIntent().getStringExtra("uname");
        redpwd = getIntent().getStringExtra("pword");
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ed3.getText().toString();
                String password = ed4.getText().toString();
                if(username.equals(reguser) && password.equals(redpwd)){
                    Toast.makeText(login.this, "Successful Login", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(login.this,Success.class);
                    startActivity(in);
                }
                else {
                    Counter--;
                    Toast.makeText(login.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                    if(Counter==0){
                        Toast.makeText(login.this, "Max Attepmts you are Blocked", Toast.LENGTH_SHORT).show();
                        b2.setEnabled(false);
                    }
                }
            }
        });
    }
}