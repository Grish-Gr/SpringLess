package maks.ter.controllers;

import maks.ter.data.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class BookController {

    private final BookShopService bookShopService;

    @Autowired
    public BookController(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @GetMapping("/index")
    public String mainPage(Model model){
        model.addAttribute("bookData", bookShopService.getBooks());
        return "index";
    }
}
