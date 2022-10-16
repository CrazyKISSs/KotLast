package ru.krisproject.kotucheniy2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import ru.krisproject.kotucheniy2.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    public static String choose_level_name;

    private ImageButton back_from_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


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

                Intent intent = new Intent(MainActivity2.this, MainActivity3_test.class);
                startActivity(intent);

                choose_level_name = DataBase.level_name[position];
                MainActivity4.index_level = position;


            }
        });

    }

}