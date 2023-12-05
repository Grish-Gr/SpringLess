package maks.ter.web;

import maks.ter.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final BookShopService bookShopService;

    @Autowired
    public AuthorController(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @GetMapping("/index")
    public String authorsPage(Model model) {
        model.addAttribute("authors", bookShopService.getAuthors());
        return "authors/index";
    }

    @GetMapping("/{id}")
    public String author(@PathVariable Long id, Model model) {
        model.addAttribute("author", bookShopService.getAuthor(id));
        return "authors/slug";
    }
}
