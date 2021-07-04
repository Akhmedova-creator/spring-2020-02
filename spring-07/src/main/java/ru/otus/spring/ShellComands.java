package ru.otus.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.service.ServiceBook;

@ShellComponent
public class ShellComands {

    @Autowired
    private ServiceBook serviceBook;

    @ShellMethod(value = "command", key = {"getAll"})
    public String getAll() {
        return String.format("Все записи: %s", serviceBook.getBooks());
    }

}