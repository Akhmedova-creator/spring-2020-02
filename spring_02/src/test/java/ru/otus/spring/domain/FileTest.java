package ru.otus.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.*;
import ru.otus.spring.Main;
import ru.otus.spring.dao.Files;
import ru.otus.spring.dao.FilesImpl;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс FileTest")
@ComponentScan
class FileTest {

    @DisplayName("Случай,когда тест не сдан")
    @Test
    void shouldHaveNegativeResultTest() throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Files files = context.getBean(FilesImpl.class);
        File file = files.getFile();
        List<String[]> list = file.getList();
        int[] array = {1, 2, 3, 4, 5};
        assertEquals("You did not pass the test(", file.getResultAnswer(file.getCountAnswers(list, array)));

    }

    @DisplayName("Случай,когда тест сдан")
    @Test
    void shouldHavePositiveResultTest() throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Files files = context.getBean(FilesImpl.class);
        File file = files.getFile();
        List<String[]> list = file.getList();
        int[] array = {8, 16, 4, 4, 16};
        assertEquals("You passed the test!!!", file.getResultAnswer(file.getCountAnswers(list, array)));

    }

}