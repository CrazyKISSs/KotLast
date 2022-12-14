package ru.krisproject.kotucheniy2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.krisproject.kotucheniy2.databinding.ActivitySignBinding;

public class SignActivity extends AppCompatActivity {

    ActivitySignBinding binding;

    Button back_from_sign;

    MediaPlayer choise_level_sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        choise_level_sound = MediaPlayer.create(this, R.raw.choise_level_sound_2);

        if (MainActivity4.count_sign > 0) {
            MainActivity4.sign_name = new String[MainActivity4.count_sign];
            MainActivity4.sign_image = new int[MainActivity4.count_sign];
            int j = 0;
            for (int i = 0; i < DataBase.count_sign_bool.length; i++) {
                if (DataBase.count_sign_bool[i]) {
                    if (j < MainActivity4.count_sign) {
                        MainActivity4.sign_name[j] = DataBase.level_name[i];
                        MainActivity4.sign_image[j] = DataBase.image[i];
                        j++;
                    }

                }
            }
        }

        binding = ActivitySignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SignGridAdapter gridAdapter = new SignGridAdapter(SignActivity.this, MainActivity4.sign_name,
                MainActivity4.sign_image);
        binding.gridViewSign.setAdapter(gridAdapter);

        back_from_sign = findViewById(R.id.back_from_sign);
        back_from_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignActivity.this, MainActivity.class);
                startActivity(intent);
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