package ru.otus.spring.domain.print;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Component
public class PrintQueImpl implements PrintQue {

    @Override
    public void print(List<String[]> list,int count) {

        for (int i = 0; i < count; i++) {
            System.out.println(Arrays.toString(list.get(i)));

        }
    }
}
