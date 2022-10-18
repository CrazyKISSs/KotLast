package ru.krisproject.kotucheniy2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import ru.krisproject.kotucheniy2.databinding.ActivityMain2Binding;

public class MainActivity2 extends FragmentActivity {

    ActivityMain2Binding binding;
    public static String choose_level_name;
    Button back_from_level;
    Button back_from_level_fragment;
    MediaPlayer choise_level_sound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        choise_level_sound = MediaPlayer.create(this, R.raw.choise_level_sound_2);
        back_from_level_fragment = findViewById(R.id.back_from_level_fragment);

        Level_Fragment fragment_level = new Level_Fragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();


        for (int i = 0; i < 100; i++) {
            int temp = i + 1;
            DataBase.level_name[i] = "Уровень " + temp;

        }


        back_from_level = findViewById(R.id.back_from_level);
        back_from_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });


        GridAdapter gridAdapter = new GridAdapter(MainActivity2.this, DataBase.level_name, DataBase.image);
        binding.gridView.setAdapter(gridAdapter);

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Intent intent = new Intent(MainActivity2.this, MainActivity3_test.class);
//                startActivity(intent);

                choose_level_name = DataBase.level_name[position];
                MainActivity4.index_level = position;

                ft.replace(R.id.fragment_level, fragment_level);
                ft.addToBackStack(null);
                ft.commit();
//
//                back_from_level_fragment.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        ft.hide(fragment_level);
//                        ft.commit();
//                    }
//                });

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!MainActivity.choise_level_sound.isPlaying())
            MainActivity.startSound(choise_level_sound);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.stopSound(choise_level_sound);
        MainActivity.stopSound(MainActivity.choise_level_sound);
    }

}