package doman;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("класс CSVFile")
class CSVFileTest  {

    @DisplayName("корректно выдается список вопросов")
    @Test
     void shouldHavegetList() throws IOException {

        List<String[]> exp = Arrays.asList(new String[]{"What is your name?"},
                new String[]{"What is your last name ?"},
                new String[]{"How is your middle name?"},
                new String[]{"How old are you?"},
                new String[]{"what is your hobby?"});

        CSVFile csvFile = new CSVFile("questions.csv");
        List<String[]> act = csvFile.getList();

        for (int i = 0; i < exp.size(); i++) {
            assertEquals(Arrays.toString(exp.get(i)), Arrays.toString(act.get(i)));
        }
    }

    @DisplayName("корректно выполняется сравнение")
    @Test
    void shouldHaveEquals() {
        CSVFile exp=new CSVFile("file");
        CSVFile act=new CSVFile("file");
        assertEquals(exp,act);
    }
}