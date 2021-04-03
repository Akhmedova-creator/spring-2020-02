package ru.otus.spring.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {
    private Long id;
    private final String title;
    private final long genreId;
    private final long authorsId;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", genreId=" + genreId +
                ", authorsId=" + authorsId +
                '}';
    }

    public Book(String title, long genreId, long authorsId) {
        this.title = title;
        this.genreId = genreId;
        this.authorsId = authorsId;
    }
}
