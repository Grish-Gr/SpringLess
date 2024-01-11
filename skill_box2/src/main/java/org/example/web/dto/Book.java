package org.example.web.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class Book {
    private Integer id;

    @NotBlank(message = "Author is not empty")
    @Length(max = 255, message = "Author length low 255")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я ,.]+$", message = "Author contains incorrect symbols. Use alphabets symbols")
    private String author;

    @NotBlank(message = "Title is not empty")
    @Length(max = 255, message = "Title length low 255")
    private String title;

    @NotNull(message = "Size is not empty")
    @Positive(message = "Size is positive")
    @Digits(integer = 4, fraction = 0, message = "Size is digit low 9999")
    private Integer size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", size=" + size +
                '}';
    }
}
