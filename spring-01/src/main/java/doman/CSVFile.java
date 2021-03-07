package doman;

import au.com.bytecode.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


public class CSVFile {
    private String name;

    public CSVFile(String name) {
        this.name = name;
    }

    public List<String[]> getList() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(name);
        //чтение CSV файла
        if(in!=null) {
            CSVReader reader = new CSVReader(new BufferedReader(
                    new InputStreamReader(in)),
                    ',', '"', 0);
            return reader.readAll();
        }
    return null;
    }

    @Override
    public boolean equals(Object csv) {
        if (csv == null) {
            return false;
        }
        if (csv.getClass() != CSVFile.class) {
            return false;
        }
        CSVFile cmp=(CSVFile)csv;
        return cmp.name.equals(this.name);
    }

}





