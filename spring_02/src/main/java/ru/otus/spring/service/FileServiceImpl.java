package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.spring.dao.Files;
import ru.otus.spring.domain.File;

@Service
public class FileServiceImpl implements FileService {

    private Files files;

    @Autowired
    public FileServiceImpl(@Qualifier("filesImpl") Files files) {
        this.files = files;

    }

    @Override
    public File readFile() {
        return files.getFile();
    }

}
