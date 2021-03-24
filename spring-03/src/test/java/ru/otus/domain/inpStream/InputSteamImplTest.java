package ru.otus.domain.inpStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.NotNull;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("Запуск теста для класса InputStream")
class InputSteamImplTest {

    @Autowired
    private InputStream inputSteam;


    @DisplayName("Проверка теста для метода getStream ")
    @Test
    void shouldHaveNotNullGetStream() {
        assertNotNull(inputSteam.getSteam());

    }


    @DisplayName("Проверка теста для метода геттера ")
    @Test
    void shouldHaveCorrectGet() {
       assertEquals("questions.csv",inputSteam.getPathName());

    }

}