package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.Test;
import ru.otus.spring.service.TestService;
import ru.otus.spring.service.TestServiceImpl;

import java.io.IOException;

@ComponentScan
@Component
public class Main {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
     TestService testService=context.getBean(TestServiceImpl.class);

       testService.getTest().getTest();



    }
}
