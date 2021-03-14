package ru.otus.spring.domain;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.print.PrintQue;
import ru.otus.spring.domain.print.PrintQueImpl;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class Test {

    PrintQue printQue;
    private String path;
    int count;

    public Test(String path,int count) { this.path = path; this.count=count; }

    @Autowired
    public Test(PrintQue printQue) {
        this.printQue = printQue;
    }

    public void getTest() throws IOException {

        CSVReader reader = new CSVReader(new BufferedReader(new FileReader(path)), ',', '"', 0);

        printQue.print(reader.readAll(),count);
   }

}
