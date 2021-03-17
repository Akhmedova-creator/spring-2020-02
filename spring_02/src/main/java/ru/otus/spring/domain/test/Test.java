package ru.otus.spring.domain.test;

import java.io.IOException;
import java.util.List;

public interface Test {
    List<String[]> getList() throws IOException;
    int getSizeList();

}
