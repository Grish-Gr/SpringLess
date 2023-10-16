package maks.ter.data;

import maks.ter.model.Author;
import maks.ter.model.Book;
import maks.ter.model.Genre;
import maks.ter.repository.AuthorRepository;
import maks.ter.repository.BookRepository;
import maks.ter.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookShopService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    private GenreRepository genreRepository;

    @Autowired
    public BookShopService(AuthorRepository authorRepository, BookRepository bookRepository, GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }
}
