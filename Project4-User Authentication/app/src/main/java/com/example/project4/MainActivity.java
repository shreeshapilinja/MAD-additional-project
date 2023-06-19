package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.txt1);
        ed2 = findViewById(R.id.txt2);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = ed1.getText().toString();
                String password = ed2.getText().toString();
                if(validate(password)){
                    Toast.makeText(MainActivity.this, "Signup Successful !", Toast.LENGTH_SHORT).show();
                    Intent intlogin = new Intent(MainActivity.this,login.class);
                    intlogin.putExtra("pword",password);
                    intlogin.putExtra("uname",username);
                    startActivity(intlogin);
                }
                else {
                    Toast.makeText(MainActivity.this, "Signup Unsuccessful !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private Boolean validate(String pw){
        Pattern ptrn;
        Matcher mtch;
        String pwd = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@$%^&()_]).{8,}$";
        ptrn = Pattern.compile(pwd);
        mtch = ptrn.matcher(pw);
        return mtch.matches();
    }
}