package maks.ter.repository;

import maks.ter.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> getAllByTitleContainsIgnoreCase(String title);

    Page<Book> findAllByPublishDateBetween(Pageable pageable, Date startDate, Date endDate);

    Page<Book> findAllByTagsContains(Pageable pageable, String tag);

    Page<Book> findAllByAuthor_Id(Pageable pageable, Long id);

    Long countAllByTagsContains(String slug);
}
