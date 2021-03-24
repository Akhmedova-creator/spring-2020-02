package ru.otus.domain.test;


import au.com.bytecode.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.domain.inpStream.InputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class TestImpl implements Test {
    private InputStream impStream;

    @Autowired
    public TestImpl(InputStream impStream) {
        this.impStream = impStream;
    }

    final private int SIZELIST=5;

    public int getSizeList() {
        return SIZELIST;
    }


    public   List<String[]> getList() throws IOException {
        //чтение CSV файла
            CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(impStream.getSteam())),
                    ',', '"', 0);
            return reader.readAll();
    }
}
