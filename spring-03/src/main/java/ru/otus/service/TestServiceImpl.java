package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.dao.Tests;
import ru.otus.domain.testResult.TestResult;

import java.io.IOException;

@Service
public class TestServiceImpl implements TestService {

    private Tests tests;

    @Autowired
    public TestServiceImpl(Tests tests) {
        this.tests = tests;
    }

    @Override
    public TestResult getTest () throws IOException {  return tests.getResult();}

}
