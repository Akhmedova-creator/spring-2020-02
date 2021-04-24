package ru.otus.spring.dao;

import lombok.val;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.spring.domain.Authors;
import ru.otus.spring.domain.Books;
import ru.otus.spring.domain.Comments;
import ru.otus.spring.domain.Genre;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("класс BooksDaoJdbcTest")
@DataJpaTest
@Import({BooksDaoRepositoriesJPAImpl.class})

class BooksDaoJdbcTest {

    @Autowired
   private BooksDaoRepositoriesJPA  booksDaoJdbc;

    @Autowired
    private TestEntityManager em;

    private static final long FIRST_STUDENT_ID = 1L;
    private static final long SECOND_STUDENT_ID = 2L;
    private static final String TITLE ="Алгоритмы";
    private static final int SIZE_BOOKS =4;
    private static final int EXPECTED_QUERIES_COUNT=6;


    @DisplayName("проверка метода getCount")
    @Test
    void shouldReturnExpectedBookCount() {
        int expectedBookCount = booksDaoJdbc.count();
        assertThat(expectedBookCount).isEqualTo(SIZE_BOOKS);
    }

    @DisplayName("проверка метода InsertBook")
    @Test
    void shouldInsertBook() {
        String title = "Гарри Потор";
        val genre = new Genre("Фантастика");
        val authors = new Authors("Карл", "Маркс");
        List<Comments> comments= Arrays.asList(new Comments("Исправили имя", LocalDate.now()));
        val book = new Books(title, genre, authors,comments);
        booksDaoJdbc.insert(book);

       assertThat(book.getId()).isGreaterThan(0);

        val actualBooks = em.find(Books.class, book.getId());

        System.out.println(actualBooks.getTitle());
        System.out.println(actualBooks.getAuthors());
        System.out.println(actualBooks.getComments());
        System.out.println(actualBooks.getGenre());

        assertThat(actualBooks).isNotNull().matches(b -> !b.getTitle().equals(""))
                .matches(b -> b.getAuthors() != null)
                .matches(b -> b.getGenre() != null)
                .matches(b -> b.getComments() != null);
    }
    @DisplayName("должен корректно выдавать книгу по Id")
    @Test
    void shouldReturnExpectedBookById() {
        Books actualBook = booksDaoJdbc.getById(FIRST_STUDENT_ID);
        assertThat(actualBook).isEqualToIgnoringNullFields(em.find(Books.class,FIRST_STUDENT_ID));
    }

    @DisplayName("Должен корректно книгу удалять по id")
    @Test
    void shouldDeleteBook() {
        val firstBook = em.find(Books.class, SECOND_STUDENT_ID);
        assertThat(firstBook).isNotNull();
        em.detach(firstBook);

        booksDaoJdbc.delete(SECOND_STUDENT_ID);
        val  deleteBook = em.find(Books.class, SECOND_STUDENT_ID);

        assertThat(deleteBook).isNull();
    }

    @DisplayName(" должен изменять имя книги по его id")
    @Test
    void shouldUpdateBook() {
        val firstStudent = em.find(Books.class, FIRST_STUDENT_ID);
        String oldTitle = firstStudent.getTitle();
        em.detach(firstStudent);

        booksDaoJdbc.update(TITLE, FIRST_STUDENT_ID);

        assertThat(booksDaoJdbc.getById(FIRST_STUDENT_ID).getTitle()).isNotEqualTo(oldTitle);
    }

    @Test
    void shouldReturnExpectedBookAll() {
        SessionFactory sessionFactory = em.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);

        val books = booksDaoJdbc.getAll();
        assertThat(books).isNotNull().hasSize(SIZE_BOOKS)
                .allMatch(b -> !b.getTitle().equals(""))
                .allMatch(b -> b.getAuthors() != null)
                .allMatch(b -> b.getGenre() != null)
                .allMatch(b -> b.getComments() != null);
        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_QUERIES_COUNT);

    }
}

