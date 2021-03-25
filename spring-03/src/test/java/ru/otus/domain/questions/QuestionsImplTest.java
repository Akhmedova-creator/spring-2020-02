package ru.otus.domain.questions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DisplayName("проверка класса  QuestionsImpl")
class QuestionsImplTest {

    @Autowired
    private Questions questions;

    @DisplayName("проверка метода  getQuestions")
    @Test
    void shouldHaveGetQuestions() throws IOException {
        List<String> exp =Arrays.asList("How many bytes does the int data type have?",
                "How many bytes does the double data type have?",
                "How many bytes does the char data type have?",
                "How many bytes does a short data type have?",
                "How many bytes does a long data type have?");
            assertEquals(exp, questions.getQuestions());

    }
}