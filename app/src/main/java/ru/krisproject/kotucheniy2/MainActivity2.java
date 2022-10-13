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
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question
            , R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question, R.drawable.level_image_question};

    
    public static int[] collect_image_for_levels = {R.drawable.level_image_1,
            R.drawable.level_image_2, R.drawable.level_image_3, R.drawable.level_image_22
            , R.drawable.level_image_4, R.drawable.level_image_5, R.drawable.level_image_6, R.drawable.level_image_7
            , R.drawable.level_image_8, R.drawable.level_image_9, R.drawable.level_image_10, R.drawable.level_image_11
            , R.drawable.level_image_12, R.drawable.level_image_13, R.drawable.level_image_14, R.drawable.level_image_15
            , R.drawable.level_image_16, R.drawable.level_image_18, R.drawable.level_image_19, R.drawable.level_image_20
            , R.drawable.level_image_21, R.drawable.level_image_23, R.drawable.level_image_24, R.drawable.level_image_25
            , R.drawable.level_image_26, R.drawable.level_image_27, R.drawable.level_image_28, R.drawable.level_image_29
            , R.drawable.level_image_30, R.drawable.level_image_31, R.drawable.level_image_32, R.drawable.level_image_33
            , R.drawable.level_image_34, R.drawable.level_image_35, R.drawable.level_image_36, R.drawable.level_image_37
            , R.drawable.level_image_38, R.drawable.level_image_39, R.drawable.level_image_40, R.drawable.level_image_41
            , R.drawable.level_image_42, R.drawable.level_image_43, R.drawable.level_image_44, R.drawable.level_image_45
            , R.drawable.level_image_46, R.drawable.level_image_47, R.drawable.level_image_48, R.drawable.level_image_49
            , R.drawable.level_image_50, R.drawable.level_image_51, R.drawable.level_image_52, R.drawable.level_image_53
            , R.drawable.level_image_54, R.drawable.level_image_55, R.drawable.level_image_56, R.drawable.level_image_57
            , R.drawable.level_image_58, R.drawable.level_image_59, R.drawable.level_image_60, R.drawable.level_image_61
            , R.drawable.level_image_62, R.drawable.level_image_63, R.drawable.level_image_64, R.drawable.level_image_65
            , R.drawable.level_image_66, R.drawable.level_image_67, R.drawable.level_image_68, R.drawable.level_image_69
            , R.drawable.level_image_70, R.drawable.level_image_71, R.drawable.level_image_72, R.drawable.level_image_73
            , R.drawable.level_image_74, R.drawable.level_image_75, R.drawable.level_image_76, R.drawable.level_image_77
            , R.drawable.level_image_78, R.drawable.level_image_79, R.drawable.level_image_80, R.drawable.level_image_81
            , R.drawable.level_image_82, R.drawable.level_image_83, R.drawable.level_image_84, R.drawable.level_image_85
            , R.drawable.level_image_86, R.drawable.level_image_87, R.drawable.level_image_88, R.drawable.level_image_89
            , R.drawable.level_image_90, R.drawable.level_image_91, R.drawable.level_image_92, R.drawable.level_image_93
            , R.drawable.level_image_94, R.drawable.level_image_95, R.drawable.level_image_96, R.drawable.level_image_97
            , R.drawable.level_image_98, R.drawable.level_image_99, R.drawable.level_image_100, R.drawable.level_image_101};


    ActivityMain2Binding binding;

    public static String choose_level_name;


    String[] level_name = {"Уровень 1", "Уровень 2", "Уровень 3", "Уровень 4", "Уровень 5", "Уровень 6", "Уровень 7",
            "Уровень 8", "Уровень 9", "Уровень 10", "Уровень 11", "Уровень 12", "Уровень 13", "Уровень 14", "Уровень 15",
            "Уровень 16", "Уровень 17", "Уровень 18", "Уровень 19", "Уровень 20", "Уровень 21", "Уровень 22", "Уровень 23", "Уровень 24", "Уровень 25",
            "Уровень 26", "Уровень 27", "Уровень 28", "Уровень 29", "Уровень 30", "Уровень 31", "Уровень 32",
            "Уровень 33", "Уровень 34", "Уровень 35", "Уровень 36", "Уровень 37", "Уровень 38", "Уровень 39",
            "Уровень 40", "Уровень 41", "Уровень 42", "Уровень 43", "Уровень 44", "Уровень 45", "Уровень 46",
            "Уровень 46", "Уровень 48", "Уровень 49", "Уровень 50", "Уровень 51", "Уровень 52", "Уровень 53",
            "Уровень 54", "Уровень 55", "Уровень 56", "Уровень 57", "Уровень 58", "Уровень 59", "Уровень 60",
            "Уровень 61", "Уровень 62", "Уровень 63", "Уровень 64", "Уровень 65", "Уровень 66", "Уровень 67",
            "Уровень 68", "Уровень 69", "Уровень 70", "Уровень 71", "Уровень 72", "Уровень 73", "Уровень 74",
            "Уровень 75", "Уровень 76", "Уровень 77", "Уровень 78", "Уровень 79", "Уровень 80", "Уровень 81",
            "Уровень 82", "Уровень 83", "Уровень 84", "Уровень 85", "Уровень 86", "Уровень 87", "Уровень 88",
            "Уровень 89", "Уровень 90", "Уровень 91", "Уровень 92", "Уровень 93", "Уровень 94", "Уровень 95",
            "Уровень 96", "Уровень 97", "Уровень 98", "Уровень 99", "Уровень 100"};

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
                MainActivity4.index_level = position;


            }
        });

    }
}