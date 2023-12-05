package maks.ter.repository;

import maks.ter.model.Book;
import maks.ter.model.BookGenre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenreRepository extends JpaRepository<BookGenre, Long> {

    Page<BookGenre> findAllByGenre_Id(Pageable pageable, Long id);
}
