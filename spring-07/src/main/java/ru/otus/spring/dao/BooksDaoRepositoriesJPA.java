package ru.otus.spring.dao;

import ru.otus.spring.domain.Books;

import java.util.List;

public interface BooksDaoRepositoriesJPA {
   Integer count();

   Books insert(Books book);

    Books getById(Long id);

    void update(String title, long id);

    void delete(long id);

    List<Books> getAll();
}
