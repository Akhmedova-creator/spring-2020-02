package dao;

import doman.CSVFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("класс CSVFilesImpl ")
class CSVFilesImplTest  {

    @Test
    @DisplayName("корректно задаются сеттеры")
    void setName() {
        CSVFilesImpl csvFiles=new CSVFilesImpl();
        csvFiles.setName("filename");
        assertEquals(csvFiles.getName(),"filename");
    }

    @Test
    @DisplayName("корректно задаются геттеры")
    void getName() {
        CSVFilesImpl csvFiles=new CSVFilesImpl();
        csvFiles.setName("filename");
        assertEquals("filename",csvFiles.getName());

    }

    @DisplayName("корректно создается и возвращается CSVFile ")
    @Test
    void shouldHaveCSVFile() {
        CSVFilesImpl csvFiles=new CSVFilesImpl();
        csvFiles.setName("file");
        CSVFile csvFile=new CSVFile("file");
        assertEquals(csvFiles.getCSVFile(),csvFile);
    }
}