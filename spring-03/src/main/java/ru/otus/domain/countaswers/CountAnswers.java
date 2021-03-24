package ru.otus.domain.countaswers;

import org.springframework.beans.factory.annotation.Qualifier;
import ru.otus.domain.answers.Answers;
import ru.otus.domain.correctAnswers.CorrectAnswers;

import java.io.IOException;

public interface CountAnswers {

    int getCountAnswers() throws IOException;

}
