import doman.CSVFile;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CSVService;
import service.CSVServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("spring-context.xml");

        CSVService csvService = context.getBean(CSVServiceImpl.class);
        CSVFile csvFile = csvService.readCSV();
        try {
            List<String[]> list = csvFile.getList();
            //красивый вывод
            for (String[] val : list) {
                System.out.println((Arrays.toString(val)).substring(1,
                        (Arrays.toString(val)).length() - 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
