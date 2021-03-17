package ru.otus.spring.domain.test;
import au.com.bytecode.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.inpStream.ImpStream;

import java.io.*;
import java.util.List;

@Service
public class TestImpl implements Test {
    @Autowired
    private ImpStream impStream;

    final private int sizeList=5;

    public int getSizeList() {
        return sizeList;
    }

    public   List<String[]> getList() throws IOException {
        //чтение CSV файла
            CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(impStream.getSteam())),
                    ',', '"', 0);
            return reader.readAll();
    }
}
