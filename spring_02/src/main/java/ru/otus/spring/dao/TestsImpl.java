package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.testResult.TestResult;
import java.io.IOException;

@Component
public class TestsImpl implements Tests {

@Autowired
private TestResult testResult;

    @Override
    public TestResult getResult() throws IOException {
      return  testResult;
    }
}

