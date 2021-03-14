//package ru.otus.spring.domain;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Tests;
//import org.springframework.context.annotation.*;
//import ru.otus.spring.Main;
//import ru.otus.spring.dao.Tests;
//import ru.otus.spring.dao.TestsImpl;
//
//import java.io.IOException;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DisplayName("Класс FileImplTest")
//@ComponentScan
//class FileImplTest {
//
//    @DisplayName("Случай,когда тест не сдан")
//    @Tests
//    void shouldHaveNegativeResultTest() throws IOException {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//        Tests files = context.getBean(TestsImpl.class);
//        FileQuestionsImpl fileImpl = files.getFile();
//        List<String[]> list = fileImpl.getList();
//        int[] array = {1, 2, 3, 4, 5};
//        assertEquals("You did not pass the test(", fileImpl.getResultAnswer(fileImpl.getCountAnswers(list, array)));
//
//    }
//
//    @DisplayName("Случай,когда тест сдан")
//    @Tests
//    void shouldHavePositiveResultTest() throws IOException {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//        Tests files = context.getBean(TestsImpl.class);
//        FileQuestionsImpl fileImpl = files.getFile();
//        List<String[]> list = fileImpl.getList();
//        int[] array = {8, 16, 4, 4, 16};
//        assertEquals("You passed the test!!!", fileImpl.getResultAnswer(fileImpl.getCountAnswers(list, array)));
//
//    }
//
//}