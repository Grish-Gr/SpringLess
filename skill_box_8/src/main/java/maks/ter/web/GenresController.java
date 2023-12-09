package maks.ter.web;

import maks.ter.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genres")
public class GenresController {

    private BookShopService bookShopService;

    @Autowired
    public GenresController(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @GetMapping({"", "/index"})
    public String genres(Model model) {
        model.addAttribute("genres", bookShopService.getGenres());
        return "genres/index";
    }

    @GetMapping("/{id}")
    public String genres(@PathVariable Long id) {
        return "genres/slug";
    }
}
