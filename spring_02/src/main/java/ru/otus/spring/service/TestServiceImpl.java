package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.Tests;
import ru.otus.spring.domain.testResult.TestResult;

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
