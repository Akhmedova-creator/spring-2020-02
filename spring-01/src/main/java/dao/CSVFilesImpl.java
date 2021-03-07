package dao;

import doman.CSVFile;

public class CSVFilesImpl implements CSVFiles {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public CSVFile getCSVFile() {
        return new CSVFile(name);
    }

}
