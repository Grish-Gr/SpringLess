package maks.ter.controllers;

import maks.ter.data.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookShopService bookShopService;

    @Autowired
    public BookController(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @GetMapping("")
    public String mainPage(Model model){
        model.addAttribute("bookData", bookShopService.getBooks());
        return "index";
    }

    @GetMapping("/recent")
    public String recent(Model model){
        model.addAttribute("bookData", bookShopService.getBooks());
        return "books/recent";
    }

    @GetMapping("/popular")
    public String popular(Model model){
        model.addAttribute("bookData", bookShopService.getBooks());
        return "books/popular";
    }
}
