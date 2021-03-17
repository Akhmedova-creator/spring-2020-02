package ru.otus.spring.domain.correctAnswers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.questions.Questions;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CorrectAnswersImpl implements CorrectAnswers {

    @Autowired
    private Questions questions;

    @Override
    public int[] print() throws IOException {

        String question[] = questions.getQuestions();
        int[] answers = new int[question.length];

        for (int i = 0; i < question.length; i++) {
            System.out.println(question[i]);
            Scanner sc = new Scanner(System.in);
            answers[i] = sc.nextInt();
        }
    return answers;
    }
}
