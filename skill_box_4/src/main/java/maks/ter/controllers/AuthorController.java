package maks.ter.controllers;

import maks.ter.data.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private BookShopService bookShopService;

    @Autowired
    public AuthorController(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @GetMapping("/index")
    public String authorsPage(Model model) {
        model.addAttribute("authors", bookShopService.getAuthors());
        return "authors/index";
    }
}
