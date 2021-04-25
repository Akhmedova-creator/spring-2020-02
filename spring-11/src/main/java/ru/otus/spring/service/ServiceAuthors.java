package ru.otus.spring.service;

import ru.otus.spring.domain.Authors;

import java.util.List;
import org.springframework.data.domain.Sort;
public interface ServiceAuthors {
    List<Authors> getAuthors(Sort sort);
    Authors findByFirstName(String name);
}
