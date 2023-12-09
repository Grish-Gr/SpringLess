package maks.ter.api;

import maks.ter.api.dto.BookDto;
import maks.ter.api.dto.BookPage;
import maks.ter.model.Book;
import maks.ter.service.UserInfoService;
import maks.ter.service.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController()
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/info", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody UserInfoDto getUserInfo(HttpServletResponse response) {
        Cookie cookie = new Cookie("user_id", "1");
        cookie.setPath("/");
        cookie.setMaxAge(86400);

        response.addCookie(cookie);
        response.setContentType("text/plain");

        return userInfoService.getUserInfo(1L);
    }


    @GetMapping(value = "/postponed/list", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody BookPage getPostponedListBooks(@RequestParam Integer offset, @RequestParam Integer limit, @CookieValue(value = "user_id") Long id) {

        Page<Book> page = userInfoService.getPostponedBooks(PageRequest.of(offset, limit), id, "postponed");

        List<BookDto> books = page.stream()
                .map(book -> new BookDto(book.getId(), book.getTitle(), book.getPrice(), book.getPriceOld(), book.getAuthor().getFullName()))
                .toList();

        return new BookPage(books, page.getTotalElements() < (long) offset * limit);
    }

    @PostMapping(value = "/postponed/{bookId}", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody void savePostponedBook(@PathVariable Long bookId, @CookieValue(value = "user_id") Long userId) {

        if (userId == null) {
            userId = 1L;
        }

        userInfoService.savePostponedBook(userId, bookId);
    }

    @PostMapping(value = "/postponed/delete/{bookId}", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody String deletePostponedListBooks(@PathVariable Long bookId, @CookieValue(value = "user_id") Long userId) {

        if (userId == null) {
            userId = 1L;
        }

        userInfoService.deletePostponedBook(userId, bookId);

        return "OK";
    }
}
