package ru.otus.spring.domain.answers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.answers.Answers;
import ru.otus.spring.domain.test.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class AnswersImpl implements Answers {
    @Autowired
    private Test test;

    public int[] getAnswers() throws IOException {
        List<String[]> list=test.getList();
        int len=0;
        int[] ans = new int[test.getSizeList()];
        for (int i = ans.length+1; i <ans.length*2; i++) {
            String temp = Arrays.toString(list.get(i));
            ans[len]=Integer.valueOf(temp.substring(1, temp.length() - 1));
            len++;
        }
        return ans;
    }

}
