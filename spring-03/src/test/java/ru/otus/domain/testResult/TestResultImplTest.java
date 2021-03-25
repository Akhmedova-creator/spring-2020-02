package ru.otus.domain.testResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.domain.answers.Answers;
import ru.otus.domain.correctAnswers.CorrectAnswers;
import ru.otus.domain.countaswers.CountAnswers;
import ru.otus.domain.countaswers.CountAnswersImpl;
import ru.otus.domain.countaswers.OtherAnswers;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DisplayName("тестирование класса TestResultImpl")
class TestResultImplTest {
    @Autowired
    private Answers answers;

    @Test
    void shouldHaveGetResultNegativeAnswer() throws IOException {
        CorrectAnswers correctAnswers=new OtherAnswers();
        correctAnswers.setAnswers(Arrays.asList(1,2,3,4,5));
        CountAnswers countAnswers=new CountAnswersImpl(correctAnswers,answers);
        TestResult testResult=new TestResultImpl(countAnswers);
        assertEquals("You did not pass the test(",testResult.getResultAnswer());
    }

    @Test
    void shouldHaveGetResultPositiveAnswer() throws IOException {
        CorrectAnswers correctAnswers=new OtherAnswers();
        correctAnswers.setAnswers(Arrays.asList(8,16,4,4,16));
        CountAnswers countAnswers=new CountAnswersImpl(correctAnswers,answers);
        TestResult testResult=new TestResultImpl(countAnswers);
        assertEquals("You passed the test!!!",testResult.getResultAnswer());
    }
}