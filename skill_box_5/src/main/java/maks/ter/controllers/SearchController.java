package maks.ter.controllers;


import maks.ter.data.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("search")
public class SearchController {

    private final BookShopService bookShopService;

    @Autowired
    public SearchController(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @GetMapping("/{title}")
    public String index(@PathVariable String title, Model model) {
        model.addAttribute("bookData", bookShopService.getBooksByTitle(title.trim()));
        return "search/index";
    }
}
