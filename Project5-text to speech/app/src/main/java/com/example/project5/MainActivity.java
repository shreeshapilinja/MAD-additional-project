package com.example.project5;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText et1;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.ed1);
        b1 = findViewById(R.id.bt1);
        t1 = new TextToSpeech(getApplicationContext(),status -> {
            if(status!=TextToSpeech.ERROR){
                t1.setLanguage(Locale.ENGLISH);
            }
        });
    }
    public void convert(View view){
        String tospeak = et1.getText().toString();
        t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
    }
}