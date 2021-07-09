package ru.otus.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.otus.spring.domain.Genre;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre,Long> {
    Genre findByName(String name);

    List<Genre> findAll();
}
