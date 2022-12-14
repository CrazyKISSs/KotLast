package ru.krisproject.kotucheniy2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button_main_start, sign_collection;

    public static MediaPlayer choise_level_sound;


    public static void startSound(MediaPlayer sound) {
        sound.seekTo(0);
        sound.start();
        sound.setVolume(0.5f, 0.5f);
        sound.setLooping(true);
    }

    public static void stopSound(MediaPlayer sound) {
        sound.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choise_level_sound = MediaPlayer.create(this, R.raw.choise_level_sound_2);
        startSound(choise_level_sound);

        for (int i = 0; i < 100; i++) {
            int temp = i + 1;
            DataBase.level_name[i] = "Уровень " + temp;

        }

        button_main_start = findViewById(R.id.button_main_start);
        sign_collection = findViewById(R.id.sign_collection);

        sign_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignActivity.class);
                startActivity(intent);
            }
        });

        button_main_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopSound(choise_level_sound);
    }

}