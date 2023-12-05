package maks.ter.api.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;


public class BookPage {
    @JsonSerialize
    List<BookDto> books;

    @JsonSerialize
    Boolean isLast;

    public BookPage(List<BookDto> books, Boolean isLast) {
        this.books = books;
        this.isLast = isLast;
    }
}
