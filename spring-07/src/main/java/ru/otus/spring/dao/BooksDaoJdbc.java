package ru.otus.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class BooksDaoJdbc implements BooksDao {

    private static class PersonMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long genreId = resultSet.getLong("genreId");
            long authorsId = resultSet.getLong("authorsId");
            String title = resultSet.getString("title");
            return new Book(title, genreId, authorsId);
        }
    }

    private final NamedParameterJdbcOperations jdbc;

    public BooksDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }


    @Override
    public int count() {
        return jdbc.getJdbcOperations().queryForObject("select count (*) from books", Integer.class);

    }

    @Override
    public long insert(Book book) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("title", book.getTitle());
        params.addValue("genreId", book.getGenreId());
        params.addValue("authorsId", book.getAuthorsId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update("insert into  books(title,genreId,authorsId) values (:title,:genreId,:authorsId)", params, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public Book getById(Long id) {
        return jdbc.queryForObject("select * from books where id=:id", Map.of("id", id), new PersonMapper());
    }

    @Override
    public void delete(long id) {
        jdbc.update("delete  from books where id=:id", Map.of("id", id));
    }

    @Override
    public void update(String title, long id) {
        jdbc.update("update books set title =:title where id=:id", Map.of("title", title, "id", id));
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select * from books", new PersonMapper());
    }
}
