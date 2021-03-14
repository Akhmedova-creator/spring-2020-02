package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Test;

@PropertySource("classpath:conf.properties")
@Component
public class TestsImpl implements Tests {


    @Value("${path}")
    private String path;

    @Value("${count}")
    private int count;
    @Override
    public Test getResult() {
        return new Test(path,count);
    }
}

