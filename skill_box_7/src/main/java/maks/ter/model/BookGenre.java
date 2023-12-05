package maks.ter.model;

import liquibase.pro.packaged.C;
import liquibase.pro.packaged.E;

import javax.persistence.*;

@Entity
@Table(name = "book_to_genres")
public class BookGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
