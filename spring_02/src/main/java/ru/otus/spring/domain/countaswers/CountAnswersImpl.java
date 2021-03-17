package ru.otus.spring.domain.countaswers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.answers.Answers;
import ru.otus.spring.domain.questions.Questions;
import ru.otus.spring.domain.correctAnswers.CorrectAnswers;

import java.io.IOException;

@Service
public class CountAnswersImpl implements CountAnswers {

    @Autowired
    private CorrectAnswers printQue;

    @Autowired
    private Answers answers;

    @Autowired
    private Questions questions;

    public int getCountAnswers() throws IOException {

        int []array=printQue.print();
        int[]ans=answers.getAnswers();

      int countAnswers = 0;
        for (int i = 0; i <ans.length; i++) {
            if (ans[i] == array[i]) {
                countAnswers++;
            }
        }
    return  countAnswers ;
    }
}
