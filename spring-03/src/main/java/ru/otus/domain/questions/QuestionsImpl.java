package ru.otus.domain.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.domain.test.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuestionsImpl implements Questions {
    @Autowired
    private Test test;

    public List<String> getQuestions() throws IOException {

        List<String[]> list=test.getList();
        List<String> que = new ArrayList<>();

        for (int i = 0; i < test.getSizeList(); i++) {
            String temp = Arrays.toString(list.get(i));
            que.add(i,temp.substring(1, temp.length() - 1));
        }

         return que;
    }
}
