package com.example.project6;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    Button call,save,clear;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.ed1);
        clear = findViewById(R.id.clrbtn);
        call = findViewById(R.id.clbtn);
        save = findViewById(R.id.svbtn);
        clear.setOnClickListener(view -> et1.setText(""));
        call.setOnClickListener(view -> {
            String number = et1.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+number));
            startActivity(intent);
        });
        save.setOnClickListener(view -> {
            String number = et1.getText().toString();
            Intent intent = new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);
            intent.putExtra(ContactsContract.Intents.Insert.PHONE,number);
            startActivity(intent);
        });
    }
    public void inputnumber(View view){
        Button btn=(Button) view;
        String digit = btn.getText().toString();
        String phonenumber = et1.getText().toString();
        et1.setText(phonenumber+digit);
    }
}