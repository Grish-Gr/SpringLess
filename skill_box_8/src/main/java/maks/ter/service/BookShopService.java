package maks.ter.service;

import maks.ter.api.dto.BookDto;
import maks.ter.model.*;
import maks.ter.repository.*;
import maks.ter.service.dto.TagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookShopService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private GenreRepository genreRepository;

    private TagsRepository tagsRepository;
    private BookGenreRepository bookGenreRepository;

    @Autowired
    public BookShopService(AuthorRepository authorRepository,
                           BookRepository bookRepository,
                           GenreRepository genreRepository,
                           TagsRepository tagsRepository,
                           BookGenreRepository bookGenreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.tagsRepository = tagsRepository;
        this.bookGenreRepository = bookGenreRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Page<Book> getBooksByPage(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public Page<Book> getBooksByPageAndDates(Pageable pageable, Date startDate, Date endDate){
        return bookRepository.findAllByPublishDateBetween(pageable, startDate, endDate);
    }

    public Page<Book> getBooksByPageAndTag(Pageable pageable, String tag) {
        return bookRepository.findAllByTagsContains(pageable, tag);
    }

    public Page<BookGenre> getBooksByPageAndGenre(Pageable pageable, Long genreId) {
        return bookGenreRepository.findAllByGenre_Id(pageable, genreId);
    }

    public Page<Book> getBooksByPageAndAuthor(Pageable pageable, Long authorId) {
        return bookRepository.findAllByAuthor_Id(pageable, authorId);
    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.getAllByTitleContainsIgnoreCase(title).orElse(new ArrayList<>());
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public List<TagDto> getTags() {
        return tagsRepository.findAll().stream().map(tag -> {
            Long countBooks = bookRepository.countAllByTagsContains(tag.getSlug());
            return new TagDto(tag.getTitle(), tag.getSlug(), countBooks);
        }).toList();
    }
}
