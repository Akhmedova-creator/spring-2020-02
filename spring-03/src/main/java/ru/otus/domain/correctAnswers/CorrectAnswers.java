package ru.otus.domain.correctAnswers;

import java.io.IOException;
import java.util.List;

public interface CorrectAnswers {

    List<Integer> print() throws IOException;

    public void setAnswers(List<Integer> answers);

}
