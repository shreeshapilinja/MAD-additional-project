package com.example.project7;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {
    Button b1;
    Timer Mytimer;
    WallpaperManager Mywall;
    Drawable Mydraw;
    int nextpaper = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.click);
        Mytimer = new Timer();
        Mywall = WallpaperManager.getInstance(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changewallpaper();
            }
        });
    }
    private void changewallpaper() {
        Mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (nextpaper == 1) {
                    Mydraw = getResources().getDrawable(R.drawable.a);
                    nextpaper = 2;
                } else if (nextpaper == 2) {
                    Mydraw = getResources().getDrawable(R.drawable.b);
                    nextpaper = 3;
                } else if (nextpaper == 3) {
                    Mydraw = getResources().getDrawable(R.drawable.c);
                    nextpaper = 4;
                } else if (nextpaper == 4) {
                    Mydraw = getResources().getDrawable(R.drawable.d);
                    nextpaper = 5;
                } else if (nextpaper == 5)
                    System.exit(0);
                Bitmap wallpaper = ((BitmapDrawable) Mydraw).getBitmap();
                try {
                    Mywall.setBitmap(wallpaper);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000);
    }
}
