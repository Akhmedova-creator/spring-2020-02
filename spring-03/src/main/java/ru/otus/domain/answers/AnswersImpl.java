package ru.otus.domain.answers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.domain.test.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnswersImpl implements Answers {
    @Autowired
    private Test test;

    public List<Integer> getAnswers() throws IOException {
        List<String[]> list=test.getList();
        int len=0;
        List<Integer> ans = new ArrayList<>();
        for (int i = test.getSizeList()+1; i <test.getSizeList()*2+1; i++) {
            String temp = Arrays.toString(list.get(i));
            ans.add(len,Integer.valueOf(temp.substring(1, temp.length() - 1)));
            len++;
        }
        return ans;
    }

}
