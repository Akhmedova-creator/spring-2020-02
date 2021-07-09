package ru.otus.spring.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.otus.spring.domain.Authors;

import java.util.List;

public interface AuthorsRepository extends PagingAndSortingRepository<Authors, Long> {
    List<Authors> findAll(Sort var1);
    Authors findByFirstName(String name);
}
