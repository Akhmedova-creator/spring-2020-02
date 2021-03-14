package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.Tests;
import ru.otus.spring.domain.Test;

@Service
public class TestServiceImpl implements TestService {

    private Tests tests;

    @Autowired
    public TestServiceImpl(Tests tests) {
        this.tests = tests;
    }

    @Override
    public Test getTest () { return tests.getResult(); }

}
