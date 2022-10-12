package ru.krisproject.kotucheniy2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import ru.krisproject.kotucheniy2.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    public static int[] image = {R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question,
            R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question,
            R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question,
            R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question};

    ActivityMain2Binding binding;

    public static String choose_level_name;

    String[] level_name = {"Уровень 1", "Уровень 2", "Уровень 3", "Уровень 4", "Уровень 5", "Уровень 6", "Уровень 7",
            "Уровень 8", "Уровень 9", "Уровень 10", "Уровень 11", "Уровень 12", "Уровень 13", "Уровень 14", "Уровень 15",
            "Уровень 16", "Уровень 17", "Уровень 18", "Уровень 19", "Уровень 20", "Уровень 21", "Уровень 22", "Уровень 23", "Уровень 24", "Уровень 25",
            "Уровень 26", "Уровень 27", "Уровень 28", "Уровень 29", "Уровень 30", "Уровень 31", "Уровень 32"};

    private ImageButton back_from_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        back_from_level = findViewById(R.id.back_from_level);
        back_from_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });


        GridAdapter gridAdapter = new GridAdapter(MainActivity2.this, level_name, image);
        binding.gridView.setAdapter(gridAdapter);

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity2.this, MainActivity3_test.class);
                startActivity(intent);

                choose_level_name = level_name[position];


            }
        });

    }
}