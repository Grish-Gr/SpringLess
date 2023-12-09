package maks.ter.service;

import liquibase.pro.packaged.A;
import maks.ter.model.Book;
import maks.ter.model.UserBook;
import maks.ter.model.UserInfo;
import maks.ter.repository.BookRepository;
import maks.ter.repository.UserBookRepository;
import maks.ter.repository.UserInfoRepository;
import maks.ter.service.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserBookRepository userBookRepository;

    @Autowired
    private BookRepository bookRepository;

    public UserInfoDto getUserInfo(Long userID) {
        UserInfo userInfo = userInfoRepository.getById(userID);
        return new UserInfoDto(userInfo.getId(), userInfo.getFirstName(), userInfo.getMidName(), userInfo.getLastName(), userInfo.getLogin());
    }

    public Page<Book> getPostponedBooks(Pageable pageable, Long userID, String category) {
        return userBookRepository.findAllByUserInfo_IdAndCategory(pageable, userID, category).map(UserBook::getBook);
    }

    public UserBook savePostponedBook(Long userId, Long bookId) {
        Book book = bookRepository.getById(bookId);
        UserInfo userInfo = userInfoRepository.getById(userId);

        if (userBookRepository.findByBookAndUserInfoAndCategory(book, userInfo, "postponed") != null) {
            return null;
        }

        UserBook userBook = new UserBook();
        userBook.setBook(book);
        userBook.setUserInfo(userInfo);
        userBook.setCategory("postponed");

        return userBookRepository.save(userBook);
    }

    public void deletePostponedBook(Long userId, Long bookId) {
        Book book = bookRepository.getById(bookId);
        UserInfo userInfo = userInfoRepository.getById(userId);

        UserBook userBook = userBookRepository.findByBookAndUserInfoAndCategory(book, userInfo, "postponed");

        if (userBook == null) {
            return;
        }

        userBookRepository.delete(userBook);
    }
}
