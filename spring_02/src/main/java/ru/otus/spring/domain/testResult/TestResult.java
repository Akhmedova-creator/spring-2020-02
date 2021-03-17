package ru.otus.spring.domain.testResult;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.spring.domain.countaswers.CountAnswers;

import java.io.IOException;

public interface TestResult {

      String getResultAnswer() throws IOException;
}