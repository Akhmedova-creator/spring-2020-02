package ru.otus.spring.service;


import ru.otus.spring.domain.testResult.TestResult;

import java.io.IOException;

public interface TestService {
    TestResult getTest() throws IOException;
}
