package ru.otus.domain.correctAnswers;

import java.io.IOException;
import java.util.List;

public interface CorrectAnswers {

    List<Integer> print();

    public void setAnswers(List<Integer> answers);

}
