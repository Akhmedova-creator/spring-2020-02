package ru.otus.spring.domain.testResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.countaswers.CountAnswers;
import java.io.IOException;

@Service
public class TestResultImpl implements TestResult {

    @Autowired
    private CountAnswers countAnswers;
    private final int ANSWERCOUNT=4;

    @Override
    public String getResultAnswer() throws IOException {
        if (countAnswers.getCountAnswers()>=ANSWERCOUNT) {
            return TextAnswer.PositiveText.getText() ;
        } else return TextAnswer.NegativeText.getText();
    }
}
