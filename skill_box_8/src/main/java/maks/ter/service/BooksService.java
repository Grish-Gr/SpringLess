package maks.ter.service;

import liquibase.pro.packaged.A;
import maks.ter.model.Book;
import maks.ter.repository.BookRepository;
import maks.ter.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TagsRepository tagsRepository;


    public Book getBook(Long id) {
        return bookRepository.getById(id);
    }

}
