package ru.krisproject.kotucheniy2;

public class Quiz {

    String name;
    Question[] questions = new Question[10];
    int count_correct_answers;

    public Quiz(String name) {
        this.name = name;
        for (int i = 0; i < 10; i++) {
            this.questions[i] = new Question();
        }
    }
}
