package maks.ter.model;


import javax.persistence.*;

@Entity
@Table(name = "book_files")
public class BookFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private Byte[] content;

    @Column(name = "file_type")
    private String fileType;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    public BookFile() {
    }

    public BookFile(Byte[] content, String fileType, Book book) {
        this.content = content;
        this.fileType = fileType;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte[] getContent() {
        return content;
    }

    public void setContent(Byte[] content) {
        this.content = content;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}