package ru.otus.domain.countaswers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.domain.answers.Answers;
import ru.otus.domain.correctAnswers.CorrectAnswers;
import java.io.IOException;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Тесирование класса CountAnswersImpl ")
class CountAnswersImplTest {

   @Autowired
    private Answers answers;

    @DisplayName("Тестирование метода getCountAnswers ")
    @Test
    void shouldHaveCorrectGetCountAnswers() throws IOException {
        CorrectAnswers correctAnswers=new OtherAnswers();
        correctAnswers.setAnswers(Arrays.asList(1,2,3,4,5));
        CountAnswers countAnswers=new CountAnswersImpl(correctAnswers,answers);
       assertEquals(1,countAnswers.getCountAnswers());

    }
}