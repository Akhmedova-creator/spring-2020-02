package ru.otus.spring.dao;

import ru.otus.spring.domain.testResult.TestResult;
import java.io.IOException;

public interface Tests {
    TestResult getResult() throws IOException;
}
