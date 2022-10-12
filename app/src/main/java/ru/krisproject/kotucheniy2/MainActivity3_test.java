package ru.krisproject.kotucheniy2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3_test extends AppCompatActivity {

    private ImageButton back_from_test;
    public static TextView level;

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

        level = findViewById(R.id.level);

    }


}