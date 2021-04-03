package ru.otus.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.dao.BooksDao;
import ru.otus.spring.domain.Book;

@ShellComponent
public class ShellComands {

    @Autowired
    private BooksDao dao;

    @ShellMethod(value = "command", key = {"count"})
    public String count() {
        return String.format("количество записей в таблице BOOKS %d", dao.count());
    }

    @ShellMethod(value = "command", key = {"insert"})
    public String insert() {
        Book book = new Book("Хочу и буду", 2, 2);
        dao.insert(book);
        return String.format("вставили новую книгу: %s", book);
    }

    @ShellMethod(value = "command", key = {"update"})
    public String update() {
        String title = "My books";
        long id = 1;
        dao.update(title, id);
        return String.format("обновилу  книгу на наименование %s ", title);
    }

    @ShellMethod(value = "command", key = {"delete"})
    public String delete() {
        long id = 2;
        dao.delete(id);
        return String.format("удалили книгу  id %d", id);
    }

    @ShellMethod(value = "command", key = {"getAll"})
    public String getAll() {
        return String.format("Все записи: %s", dao.getAll());
    }

    @ShellMethod(value = "command", key = {"getById"})
    public String getById() {
        return String.format("Запись по id: %s", dao.getById(2l));
    }
}