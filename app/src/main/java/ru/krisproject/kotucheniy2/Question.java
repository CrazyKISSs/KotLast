package ru.krisproject.kotucheniy2;

import java.util.Random;

public class Question {
    int first_arg;
    int second_arg;
    boolean sign;
    int correct_answer;
    int wrong_answer;
    String text_of_question;

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
            this.text_of_question = "" + this.first_arg + " + " + this.second_arg;
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
            this.text_of_question = "" + this.first_arg + " - " + this.second_arg;
            this.wrong_answer = r.nextInt(101);
            while (this.wrong_answer == this.correct_answer) {
                this.wrong_answer = r.nextInt(101);
            }
        }


    }
}
