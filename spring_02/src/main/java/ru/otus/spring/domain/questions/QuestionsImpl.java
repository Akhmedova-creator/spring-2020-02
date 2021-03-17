package ru.otus.spring.domain.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.questions.Questions;
import ru.otus.spring.domain.test.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionsImpl implements Questions {
    @Autowired
    private Test test;

    public String[] getQuestions() throws IOException {

        List<String[]> list=test.getList();
        String[] que = new String[test.getSizeList()];

        for (int i = 0; i < que.length; i++) {
            String temp = Arrays.toString(list.get(i));
            que[i]=temp.substring(1, temp.length() - 1);
        }

         return que;
    }
}
