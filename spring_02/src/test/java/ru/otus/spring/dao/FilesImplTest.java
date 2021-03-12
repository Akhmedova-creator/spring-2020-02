package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("класс FilesImpl")
class FilesImplTest {

    @Test
    @DisplayName("метод shouldCorrectGetTest")
    void shouldCorrectGetTest() {
        File file=new File("questions.csv");
        Files files=new FilesImpl();
        assertEquals(file,files.getFile());
    }
}