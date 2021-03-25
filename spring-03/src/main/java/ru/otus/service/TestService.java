package ru.otus.service;

import ru.otus.domain.testResult.TestResult;

import java.io.IOException;

public interface TestService {
    TestResult getTest() throws IOException;
}
