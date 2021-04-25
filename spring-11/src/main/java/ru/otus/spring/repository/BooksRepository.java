package ru.otus.spring.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.spring.domain.Authors;
import ru.otus.spring.domain.Books;
import ru.otus.spring.domain.Genre;

import java.util.List;

public interface BooksRepository extends CrudRepository<Books,Long>{

    List<Books> findAll();
    List<Books> findByGenreAndAuthors(Genre genre, Authors authors);
}
