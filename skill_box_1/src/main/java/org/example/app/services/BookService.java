package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(BookRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        System.out.println("<<<<<<<<<<<<<<<<<<<< book");
        System.out.println(book.toString());
        if ((book.getAuthor() == null || book.getTitle().isBlank()) &&
            (book.getSize() == null || book.getSize().isBlank()) &&
            (book.getTitle() == null || book.getTitle().isBlank())
        ) {
            return;
        }

        bookRepo.store(book);
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    public boolean removeByRegex(String regexValue) {
        return bookRepo.removeByRegex(regexValue);
    }
}
