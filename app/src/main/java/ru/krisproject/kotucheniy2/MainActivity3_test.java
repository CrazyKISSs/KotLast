package ru.krisproject.kotucheniy2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity3_test extends AppCompatActivity {

    private ImageButton back_from_test;
    public static TextView level, textView5, textView7, textView24;
    Random r = new Random();
    boolean button2_correct;
    boolean button3_correct;
    private Button button, button2, button3, button4;
    private ImageView imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_test);

        back_from_test = findViewById(R.id.back_from_test);
        back_from_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3_test.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        Quiz quiz = new Quiz(MainActivity2.choose_level_name);
        textView5 = findViewById(R.id.textView5);
        textView7 = findViewById(R.id.textView7);
        textView24 = findViewById(R.id.textView24);
        imageView6 = findViewById(R.id.imageView6);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        level = findViewById(R.id.level);
        level.setText(quiz.name);


        for (int i = 0; i < 10; i++) {
            textView5.setText((i + 1) + "/10");
            button4.setVisibility(View.INVISIBLE);
            button.setText(quiz.questions[i].text_of_question);
            textView7.setText("Правильных ответов - " + quiz.count_correct_answers);
            textView24.setText("Неправильных ответов - " + quiz.count_correct_answers);
            button2.setClickable(true);
            button2.setBackground(getDrawable(R.drawable.button_choise_of_option_image));
            button3.setClickable(true);
            button3.setBackground(getDrawable(R.drawable.button_choise_of_option_image));
            int choise_answer_random = r.nextInt(Question.image_choose_answer.length);
            imageView6.setImageResource(Question.image_choose_answer[choise_answer_random]);

            //(getDrawable(r.nextInt(Question.image_choose_answer.length)));

            int temp_correct_question = r.nextInt(2);
            switch (temp_correct_question) {
                case 1:
                    button2.setText("" + quiz.questions[i].correct_answer);
                    button3.setText("" + quiz.questions[i].wrong_answer);
                    button2_correct = true;
                    button3_correct = false;
                    break;
                case 0:
                    button3.setText("" + quiz.questions[i].correct_answer);
                    button2.setText("" + quiz.questions[i].wrong_answer);
                    button3_correct = true;
                    button2_correct = false;
            }


            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    button2.setClickable(false);
                    button3.setClickable(false);
                    button4.setVisibility(View.VISIBLE);

                    if (button2_correct) {
                        quiz.count_correct_answers++;
                        button2.setBackground(getDrawable(R.drawable.button_choise_of_option_image_green));

                    } else {
                        quiz.count_wrong_answer++;
                        button2.setBackground(getDrawable(R.drawable.button_choise_of_option_image_red));
                    }


                }
            });


        }


    }


}