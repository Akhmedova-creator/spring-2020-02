package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.File;
import ru.otus.spring.service.FileService;
import ru.otus.spring.service.FileServiceImpl;

import java.io.IOException;
import java.util.List;

@ComponentScan
@Component
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        FileService fileService = context.getBean(FileServiceImpl.class);
        File csvFile = fileService.readFile();
        try {
            List<String[]> list=csvFile.getList();
            int []array=csvFile.getAnswers(list);
            System.out.println(csvFile.getResultAnswer(csvFile.getCountAnswers(list,array)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
