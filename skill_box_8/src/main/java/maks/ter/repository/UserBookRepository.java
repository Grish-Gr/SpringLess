package maks.ter.repository;

import maks.ter.model.Book;
import maks.ter.model.UserBook;
import maks.ter.model.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long> {

    Page<UserBook> findAllByUserInfo_IdAndCategory(Pageable pageable, Long userID, String category);

    UserBook findByBookAndUserInfoAndCategory(Book book, UserInfo userInfo, String category);
}
