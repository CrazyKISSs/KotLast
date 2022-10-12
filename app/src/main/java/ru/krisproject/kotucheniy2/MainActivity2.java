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

    String[] level_name = {"Уровень \n1", "Уровень \n2", "Уровень \n3", "Уровень \n4", "Уровень \n5", "Уровень \n6", "Уровень \n7",
            "Уровень \n8", "Уровень \n9", "Уровень 10", "Уровень 11", "Уровень 12", "Уровень 13", "Уровень 14", "Уровень 15",
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
                Quiz quiz = new Quiz(level_name[position]);

                MainActivity3_test.level = findViewById(R.id.level);
                MainActivity3_test.level.setText(quiz.name);

            }
        });

    }
}