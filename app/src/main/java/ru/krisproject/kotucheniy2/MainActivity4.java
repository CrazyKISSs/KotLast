package ru.krisproject.kotucheniy2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {

    static ImageView last_window_cat_image;
    static TextView last_window_text;
    static Button button_next;
    static Random random = new Random();
    static int index_level;
    static boolean index_level_great_new_image = false;

    MediaPlayer level_end_sound;

    static void startLastWindow() {

        int temp_random_image_wrong_answer = random.nextInt(Question.image_wrong_answer.length);
        int temp_random_image_correct_answer = random.nextInt(Question.image_correct_answer.length);

        switch (Quiz.count_correct_answers) {
            case 1:
                last_window_text.setText("Ты ответил(а) правильно на 1 вопрос. \nТебе нужно хорошо потренироваться," +
                        "чтобы получить значок!");
                last_window_cat_image.setImageResource(Question.image_correct_answer[temp_random_image_wrong_answer]);
                break;
            case 2:
            case 3:
            case 4:
                last_window_text.setText("Ты ответил(а) правильно на " + Quiz.count_correct_answers + " вопроса. \nПотренируйся" +
                        "ещё немного, чтобы получить значок!");
                last_window_cat_image.setImageResource(Question.image_correct_answer[temp_random_image_wrong_answer]);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                last_window_text.setText("Ты ответил(а) правильно на " + Quiz.count_correct_answers + " вопросов.\n" +
                        "Ещё немного тренировок, и ты получишь значок!");
                last_window_cat_image.setImageResource(Question.image_correct_answer[temp_random_image_correct_answer]);
                break;
            case 9:
            case 10:
                last_window_text.setText("Ты ответил(а) правильно на " + Quiz.count_correct_answers + " вопросов! \nУРА! Ты получаешь " +
                        "коллекционный значок! ПОЗДРАВЛЯЮ! Так держать!");
                last_window_cat_image.setImageResource(Question.image_correct_answer[temp_random_image_correct_answer]);
                index_level_great_new_image = true;


        }
        Quiz.count_correct_answers = 0;
        Quiz.count_wrong_answer = 0;
        Question.question_count = 0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        level_end_sound = MediaPlayer.create(this, R.raw.level_end_sound);


        last_window_cat_image = findViewById(R.id.last_window_cat_image);
        last_window_text = findViewById(R.id.last_window_text);
        button_next = findViewById(R.id.button_next);
        startLastWindow();

        if (index_level_great_new_image) {
            DataBase.image[index_level] = DataBase.collect_image_for_levels[index_level];
            index_level_great_new_image = false;

        }


        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.startSound(level_end_sound);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.stopSound(level_end_sound);

    }


}