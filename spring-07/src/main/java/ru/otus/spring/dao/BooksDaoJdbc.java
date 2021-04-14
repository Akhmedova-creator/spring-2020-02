package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Authors;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class BooksDaoJdbc implements BooksDao {
    @Autowired
    private GenreDao genreDao;

    @Autowired
    private AuthorsDao authorsDao;

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            String title = resultSet.getString("title");
            Genre genre = new Genre(resultSet.getString("name"));
            Authors authors =new Authors(resultSet.getString("first_name"),resultSet.getString("last_name"));
            return new Book(title,genre,authors);
        }
    }

    private final NamedParameterJdbcOperations jdbc;

    public BooksDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }


    @Override
    public int count() {
        return jdbc.getJdbcOperations().queryForObject("select count (title) from books", Integer.class);

    }

    @Override
    public long insert(Book book) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        int genreId=genreDao.getIdByName(book.getGenre().getName());
        int authorsId=authorsDao.getIdByFirstName(book.getAuthors().getFirst_name(),book.getAuthors().getLast_name());

        params.addValue("title", book.getTitle());
        params.addValue("genreid",genreId);
        params.addValue("authorsid",authorsId);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update("insert into  books (title,genreid,authorsId) values (:title,:genreid,:authorsid)", params, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public Book getById(Long id) {

        return jdbc.queryForObject("select b.title,g.name, a.first_name, a.last_name from books b " +
                " join genre g on g.id=b.genreid " +
                " join authors a on a.id=b.authorsid where b.id=:id", Map.of("id", id), new BookMapper());
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
        return jdbc.query("select b.title,g.name, a.first_name, a.last_name from books b " +
                " join genre g on g.id=b.genreid " +
                " join authors a on a.id=b.authorsid" , new BookMapper());
    }
}
