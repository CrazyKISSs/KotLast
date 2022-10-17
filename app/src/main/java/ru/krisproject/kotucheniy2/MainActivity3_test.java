package ru.krisproject.kotucheniy2;

import android.content.Intent;
import android.media.MediaPlayer;
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
    static Random r = new Random();
    static boolean button2_correct;
    static boolean button3_correct;
    static Button button, button2, button3, button4, start_last_window;
    static ImageView imageView6;
    public static MediaPlayer game_sound, correct_answer_sound, wrong_answer_sound;

    static void startQuestion(int n, Quiz quiz) {
        textView5.setText((n + 1) + "/10");
        button4.setVisibility(View.INVISIBLE);
        start_last_window.setVisibility(View.INVISIBLE);
        button.setText(quiz.questions[n].text_of_question);
        textView7.setText("Правильных ответов - " + Quiz.count_correct_answers);
        textView24.setText("Неправильных ответов - " + Quiz.count_wrong_answer);


        int choise_answer_random = r.nextInt(Question.image_choose_answer.length);
        imageView6.setImageResource(Question.image_choose_answer[choise_answer_random]);


        int temp_correct_question = r.nextInt(2);
        switch (temp_correct_question) {
            case 1:
                button2.setText("" + quiz.questions[n].correct_answer);
                button3.setText("" + quiz.questions[n].wrong_answer);
                button2_correct = true;
                button3_correct = false;
                break;
            case 0:
                button3.setText("" + quiz.questions[n].correct_answer);
                button2.setText("" + quiz.questions[n].wrong_answer);
                button3_correct = true;
                button2_correct = false;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_test);
        game_sound = MediaPlayer.create(this, R.raw.game_sound_2);
        correct_answer_sound = MediaPlayer.create(this, R.raw.correct_answer_sound);
        wrong_answer_sound = MediaPlayer.create(this, R.raw.wrong_answer_sound);


        Quiz quiz = new Quiz(MainActivity2.choose_level_name);
        textView5 = findViewById(R.id.textView5);
        textView7 = findViewById(R.id.textView7);
        textView24 = findViewById(R.id.textView24);
        imageView6 = findViewById(R.id.imageView6);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        start_last_window = findViewById(R.id.button_start_last_window);
        level = findViewById(R.id.level);
        level.setText(quiz.name);

        startQuestion(Question.question_count, quiz);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Question.question_count < 9) {
                    button4.setVisibility(View.VISIBLE);
                } else {
                    start_last_window.setVisibility(View.VISIBLE);
                }

                button2.setClickable(false);
                button3.setClickable(false);

                int wrong_answer_random = r.nextInt(Question.image_wrong_answer.length);
                int correct_answer_random = r.nextInt(Question.image_correct_answer.length);

                if (button2_correct) {
                    Quiz.count_correct_answers++;
                    button2.setBackground(getDrawable(R.drawable.button_choise_of_option_image_green));
                    imageView6.setImageResource(Question.image_correct_answer[correct_answer_random]);
                    correct_answer_sound.start();

                } else {
                    Quiz.count_wrong_answer++;
                    button2.setBackground(getDrawable(R.drawable.button_choise_of_option_image_red));
                    imageView6.setImageResource(Question.image_wrong_answer[wrong_answer_random]);
                    wrong_answer_sound.start();
                }

                textView7.setText("Правильных ответов - " + Quiz.count_correct_answers);
                textView24.setText("Неправильных ответов - " + Quiz.count_wrong_answer);

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Question.question_count < 9) {
                    button4.setVisibility(View.VISIBLE);
                } else {
                    start_last_window.setVisibility(View.VISIBLE);
                }

                button2.setClickable(false);
                button3.setClickable(false);

                int wrong_answer_random = r.nextInt(Question.image_wrong_answer.length);
                int correct_answer_random = r.nextInt(Question.image_correct_answer.length);

                if (button3_correct) {
                    Quiz.count_correct_answers++;
                    button3.setBackground(getDrawable(R.drawable.button_choise_of_option_image_green));
                    imageView6.setImageResource(Question.image_correct_answer[correct_answer_random]);
                    correct_answer_sound.start();

                } else {
                    Quiz.count_wrong_answer++;
                    button3.setBackground(getDrawable(R.drawable.button_choise_of_option_image_red));
                    imageView6.setImageResource(Question.image_wrong_answer[wrong_answer_random]);
                    wrong_answer_sound.start();
                }

                textView7.setText("Правильных ответов - " + Quiz.count_correct_answers);
                textView24.setText("Неправильных ответов - " + Quiz.count_wrong_answer);

            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Question.question_count++;
                button2.setClickable(true);
                button2.setBackground(getDrawable(R.drawable.button_choise_of_option_image));
                button3.setClickable(true);
                button3.setBackground(getDrawable(R.drawable.button_choise_of_option_image));
                startQuestion(Question.question_count, quiz);

            }
        });


        start_last_window.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3_test.this, MainActivity4.class);
                startActivity(intent);
                Question.question_count = 0;
            }
        });


        back_from_test = findViewById(R.id.back_from_test);
        back_from_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.count_correct_answers = 0;
                Quiz.count_wrong_answer = 0;
                Question.question_count = 0;
                Intent intent = new Intent(MainActivity3_test.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        MainActivity.startSound(game_sound);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.stopSound(game_sound);
        MainActivity.stopSound(correct_answer_sound);
        MainActivity.stopSound(wrong_answer_sound);
    }

}