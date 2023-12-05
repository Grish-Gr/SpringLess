package maks.ter.api;

import lombok.SneakyThrows;
import maks.ter.api.dto.BookPage;
import maks.ter.api.dto.BookDto;
import maks.ter.model.Book;
import maks.ter.model.BookGenre;
import maks.ter.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController()
@RequestMapping(value = "/api/book", produces = APPLICATION_JSON_VALUE)
public class BookApiController {

    @Autowired
    private BookShopService bookShopService;

    @SneakyThrows
    @GetMapping(value = "/recent/list")
    public @ResponseBody BookPage getListRecentBook(@RequestParam Integer offset,
                                                    @RequestParam Integer limit,
                                                    @RequestParam(required = false) String startDate,
                                                    @RequestParam(required = false) String endDate
    ) {

        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");

        Date start = !startDate.isEmpty() ? formatter.parse(startDate) : formatter.parse("0001-01-01");
        Date end = !endDate.isEmpty() ? formatter.parse(endDate) : formatter.parse("9999-12-30");

        Page<Book> page = bookShopService.getBooksByPageAndDates(PageRequest.of(offset, limit), start, end);

        List<BookDto> books = page.stream()
                .map(book -> new BookDto(book.getTitle(), book.getPrice(), book.getPriceOld(), book.getAuthor().getFullName()))
                .toList();

        return new BookPage(books, page.getTotalElements() < offset + limit);
    }

    @SneakyThrows
    @GetMapping(value = "/popular/list")
    public @ResponseBody BookPage getListPopularBook(@RequestParam Integer offset,
                                                     @RequestParam Integer limit,
                                                     @RequestParam(required = false) String startDate,
                                                     @RequestParam(required = false) String endDate
    ) {

        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");

        Date start = !startDate.isEmpty() ? formatter.parse(startDate) : formatter.parse("0001-01-01");
        Date end = !endDate.isEmpty() ? formatter.parse(endDate) : formatter.parse("9999-12-30");

        Page<Book> page = bookShopService.getBooksByPageAndDates(PageRequest.of(offset, limit), start, end);

        List<BookDto> books = page.stream()
                .map(book -> new BookDto(book.getTitle(), book.getPrice(), book.getPriceOld(), book.getAuthor().getFullName()))
                .toList();

        return new BookPage(books, page.getTotalElements() < (long) offset * limit);
    }

    @GetMapping(value = "/tags/list/{tag}")
    public @ResponseBody BookPage getListBooksByTag(@PathVariable String tag, @RequestParam Integer offset, @RequestParam Integer limit) {

        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");

        Page<Book> page = bookShopService.getBooksByPageAndTag(PageRequest.of(offset, limit), tag);

        List<BookDto> books = page.stream()
                .map(book -> new BookDto(book.getTitle(), book.getPrice(), book.getPriceOld(), book.getAuthor().getFullName()))
                .toList();

        return new BookPage(books, page.getTotalElements() < (long) offset * limit);
    }

    @GetMapping(value = "/genres/list/{id}")
    public @ResponseBody BookPage getListBooksByGenre(@PathVariable Long id, @RequestParam Integer offset, @RequestParam Integer limit) {

        Page<BookGenre> page = bookShopService.getBooksByPageAndGenre(PageRequest.of(offset, limit), id);

        List<BookDto> books = page.stream()
                .map(BookGenre::getBook)
                .map(book -> new BookDto(book.getTitle(), book.getPrice(), book.getPriceOld(), book.getAuthor().getFullName()))
                .toList();

        return new BookPage(books, page.getTotalElements() < (long) offset * limit);
    }

    @GetMapping(value = "/authors/list/{id}")
    public @ResponseBody BookPage getListBooksByAuthor(@PathVariable Long id, @RequestParam Integer offset, @RequestParam Integer limit) {

        Page<Book> page = bookShopService.getBooksByPageAndAuthor(PageRequest.of(offset, limit), id);

        List<BookDto> books = page.stream()
                .map(book -> new BookDto(book.getTitle(), book.getPrice(), book.getPriceOld(), book.getAuthor().getFullName()))
                .toList();

        return new BookPage(books, page.getTotalElements() < (long) offset * limit);
    }
}
