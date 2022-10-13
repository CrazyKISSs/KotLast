package ru.krisproject.kotucheniy2;

import java.util.Random;

public class Question {
    int first_arg;
    int second_arg;
    boolean sign;
    int correct_answer;
    int wrong_answer;
    String text_of_question;
    public static int question_count = 0;

    public static int[] image_choose_answer = {R.drawable.choice_answer_1, R.drawable.choise_answer_2, R.drawable.choise_answer_3
            , R.drawable.choise_answer_4, R.drawable.choise_answer_5, R.drawable.choise_answer_6, R.drawable.choise_answer_7
            , R.drawable.choise_answer_8, R.drawable.choise_answer_9, R.drawable.choise_answer_10, R.drawable.choise_answer_11
            , R.drawable.choise_answer_12, R.drawable.choise_answer_13, R.drawable.choise_answer_14, R.drawable.choise_answer_15,
            R.drawable.choise_answer_16, R.drawable.choise_answer_17, R.drawable.choise_answer_18, R.drawable.choise_answer_19
            , R.drawable.choise_answer_20, R.drawable.choise_answer_21, R.drawable.choise_answer_22
            , R.drawable.choise_answer_23, R.drawable.choise_answer_24, R.drawable.choise_answer_25};

    public static int[] image_wrong_answer = {R.drawable.wrong_answer_1, R.drawable.wrong_answer_2, R.drawable.wrong_answer_3
            , R.drawable.wrong_answer_4, R.drawable.wrong_answer_5, R.drawable.choise_answer_6, R.drawable.wrong_answer_7
            , R.drawable.wrong_answer_8, R.drawable.wrong_answer_9, R.drawable.wrong_answer_10, R.drawable.wrong_answer_11
            , R.drawable.wrong_answer_12, R.drawable.wrong_answer_13, R.drawable.wrong_answer_14, R.drawable.wrong_answer_15
            , R.drawable.wrong_answer_16, R.drawable.wrong_answer_17, R.drawable.wrong_answer_18, R.drawable.wrong_answer_19
            , R.drawable.wrong_answer_20, R.drawable.wrong_answer_21, R.drawable.wrong_answer_22, R.drawable.wrong_answer_23
            , R.drawable.wrong_answer_24, R.drawable.wrong_answer_25, R.drawable.wrong_answer_26, R.drawable.wrong_answer_27
            , R.drawable.wrong_answer_28, R.drawable.wrong_answer_29, R.drawable.wrong_answer_30, R.drawable.wrong_answer_31
            , R.drawable.wrong_answer_32, R.drawable.wrong_answer_33, R.drawable.wrong_answer_34, R.drawable.wrong_answer_35
            , R.drawable.wrong_answer_36, R.drawable.wrong_answer_37, R.drawable.wrong_answer_38};

    public static int[] image_correct_answer = {R.drawable.correct_answer_1, R.drawable.correct_answer_2
            , R.drawable.correct_answer_3, R.drawable.correct_answer_4, R.drawable.correct_answer_5
            , R.drawable.correct_answer_6, R.drawable.correct_answer_7, R.drawable.correct_answer_8, R.drawable.correct_answer_9
            , R.drawable.correct_answer_10, R.drawable.correct_answer_10, R.drawable.correct_answer_12
            , R.drawable.correct_answer_14, R.drawable.correct_answer_15, R.drawable.correct_answer_16
            , R.drawable.correct_answer_17, R.drawable.correct_answer_18, R.drawable.correct_answer_19
            , R.drawable.correct_answer_20, R.drawable.correct_answer_21, R.drawable.correct_answer_22
            , R.drawable.correct_answer_23, R.drawable.correct_answer_24, R.drawable.correct_answer_25
            , R.drawable.correct_answer_26, R.drawable.correct_answer_27, R.drawable.correct_answer_28
            , R.drawable.correct_answer_29, R.drawable.correct_answer_30, R.drawable.correct_answer_31
            , R.drawable.correct_answer_32, R.drawable.correct_answer_33, R.drawable.correct_answer_34
            , R.drawable.correct_answer_35, R.drawable.correct_answer_36, R.drawable.correct_answer_37
            , R.drawable.correct_answer_38, R.drawable.correct_answer_39, R.drawable.correct_answer_40
            , R.drawable.correct_answer_41, R.drawable.correct_answer_42, R.drawable.correct_answer_44
            , R.drawable.correct_answer_45, R.drawable.correct_answer_46, R.drawable.correct_answer_47
            , R.drawable.correct_answer_48, R.drawable.correct_answer_49};


    Random r = new Random();

    public Question() {

        int sign_random = r.nextInt(2);
        switch (sign_random) {
            case 1:
                this.sign = true;
                break;
            case 0:
                this.sign = false;
        }
        if (sign) {

            this.first_arg = r.nextInt(101);
            this.second_arg = r.nextInt(101 - this.first_arg);
            this.correct_answer = this.first_arg + this.second_arg;
            this.text_of_question = "" + this.first_arg + " + " + this.second_arg + " = ?";
            this.wrong_answer = r.nextInt(101);
            while (this.wrong_answer == this.correct_answer) {
                this.wrong_answer = r.nextInt(101);
            }
        } else {

            int temp1 = r.nextInt(101);
            int temp2 = r.nextInt(101);
            this.first_arg = Math.max(temp1, temp2);
            this.second_arg = Math.min(temp1, temp2);
            this.correct_answer = this.first_arg - this.second_arg;
            this.text_of_question = "" + this.first_arg + " - " + this.second_arg + " = ?";
            this.wrong_answer = r.nextInt(101);
            while (this.wrong_answer == this.correct_answer) {
                this.wrong_answer = r.nextInt(101);
            }
        }


    }
}
