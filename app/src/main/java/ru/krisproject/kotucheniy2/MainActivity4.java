package ru.krisproject.kotucheniy2;

import android.os.Bundle;
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

    static void startLastWindow() {

        int temp_random_image_wrong_answer = random.nextInt(Question.image_wrong_answer.length);
        int temp_random_image_correct_answer = random.nextInt(Question.image_correct_answer.length);

        switch (Quiz.count_correct_answers) {
            case 1:
                last_window_text.setText("Ты ответил(а) правильно на 1 вопрос. \nТебе нужно хорошо потренироваться," +
                        "чтобы получить значёк!");
                last_window_cat_image.setImageResource(Question.image_correct_answer[temp_random_image_wrong_answer]);
                break;
            case 2:
            case 3:
            case 4:
                last_window_text.setText("Ты ответил(а) правильно на " + Quiz.count_correct_answers + " вопроса. \nПотренируйся" +
                        "ещё немного, чтобы получить значёк!");
                last_window_cat_image.setImageResource(Question.image_correct_answer[temp_random_image_wrong_answer]);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                last_window_text.setText("Ты ответил(а) правильно на " + Quiz.count_correct_answers + " вопросов.\n" +
                        "Ещё немного тренировок, и ты получишь значёк!");
                last_window_cat_image.setImageResource(Question.image_correct_answer[temp_random_image_correct_answer]);
                break;
            case 9:
            case 10:
                last_window_text.setText("Ты ответил(а) правильно на " + Quiz.count_correct_answers + " вопросов! \nУРА! Ты получаешь" +
                        "коллекционный значёк! ПОЗДРАВЛЯЮ! Так держать!");
                last_window_cat_image.setImageResource(Question.image_correct_answer[temp_random_image_correct_answer]);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        last_window_cat_image = findViewById(R.id.last_window_cat_image);
        last_window_text = findViewById(R.id.last_window_text);
        button_next = findViewById(R.id.button_next);
        startLastWindow();


    }
}