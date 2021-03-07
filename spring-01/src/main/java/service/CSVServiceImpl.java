package service;

import dao.CSVFiles;
import doman.CSVFile;

public class CSVServiceImpl implements CSVService {
    private CSVFiles csvFiles;

    public CSVServiceImpl(CSVFiles csvFiles) {
        this.csvFiles = csvFiles;
    }

    public CSVFile readCSV() {
    return csvFiles.getCSVFile();
    }

}
