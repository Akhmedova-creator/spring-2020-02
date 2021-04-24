package ru.otus.spring.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "books")
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @ManyToOne(targetEntity = Genre.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "genreid")
    private Genre genre;

    @ManyToOne(targetEntity = Authors.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "authorsid")
    private Authors authors;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(targetEntity = Comments.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bookid")
    private List<Comments> comments;

    public Books(String title, Genre genre, Authors authors, List<Comments> comments) {
        this.title = title;
        this.genre = genre;
        this.authors = authors;
        this.comments = comments;
    }
}


