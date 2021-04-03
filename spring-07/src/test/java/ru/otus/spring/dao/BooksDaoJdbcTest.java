package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.otus.spring.domain.Book;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("класс BooksDaoJdbcTest")
@JdbcTest
@Import(BooksDaoJdbc.class)
class BooksDaoJdbcTest {

    @Autowired
    private BooksDaoJdbc booksDaoJdbc;

    @DisplayName("проверка метода getCount")
    @Test
    void shouldReturnExpectedBookCount() {
        int expectedBookCount = booksDaoJdbc.count();
        assertThat(expectedBookCount).isEqualTo(4);
    }

    @DisplayName("проверка метода InsertBook")
    @Test
    void shouldInsertBook() {
        Book actualBook = new Book("Хочу и буду", 2, 2);
        long id = booksDaoJdbc.insert(actualBook);
        Book expectedBook = booksDaoJdbc.getById(id);
        assertThat(actualBook).isEqualToIgnoringNullFields(expectedBook);
    }

    @Test
    void shouldReturnExpectedBookById() {
        Book actualBook = new Book("Хочу и буду", 2, 2);
        long id = booksDaoJdbc.insert(actualBook);
        assertThat(actualBook).isEqualToIgnoringNullFields((booksDaoJdbc.getById(id)));
    }

    @Test
    void shouldDeleteBook() {
        Book actualBook = new Book("Хочу и буду", 2, 2);
        long id = booksDaoJdbc.insert(actualBook);
        assertThat(booksDaoJdbc.getById(id)).isEqualToIgnoringNullFields((actualBook));
        booksDaoJdbc.delete(id);
        assertThatThrownBy(() -> booksDaoJdbc.getById(id)).isInstanceOf(EmptyResultDataAccessException.class);
    }

    @Test
    void shouldUpdateBook() {
        String title = "My books";
        long id = 1;
        booksDaoJdbc.update(title, id);
        assertThat(booksDaoJdbc.getById(id).getTitle()).isEqualTo(title);
    }

    @Test
    void shouldReturnExpectedBookAll() {
        String actualBooks = booksDaoJdbc.getAll().toString();
        List<Book> expectedBooks = Arrays.asList(
                new Book("Алгоритмы и структуры данных", 1, 1),
                new Book("Джава.Основы", 1, 1),
                new Book("Джава.Spring-фреймворк", 1, 1),
                new Book("50 оттенков серого", 2, 2));
        assertThat(expectedBooks.toString()).isEqualTo(actualBooks);
    }
}

