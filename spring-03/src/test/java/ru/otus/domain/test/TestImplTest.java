package ru.otus.domain.test;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Тестирование класса TestImplTest")
class TestImplTest {

    @Autowired private Test test;

    @DisplayName("Тестирование метода getList")
    @org.junit.jupiter.api.Test
    public void shouldHaveCorrectGetList() throws IOException {

       List<String[]> exp = Arrays.asList(new String[]{"How many bytes does the int data type have?"},
               new String[]{"How many bytes does the double data type have?"},
               new String[]{"How many bytes does the char data type have?"},
               new String[]{"How many bytes does a short data type have?"},
               new String[]{"How many bytes does a long data type have?"});
       for (int i = 0; i < exp.size(); i++) {
           assertEquals(Arrays.toString(exp.get(i)), Arrays.toString(test.getList().get(i)));
       }
    }

}