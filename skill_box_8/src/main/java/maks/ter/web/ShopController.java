package maks.ter.web;

import maks.ter.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ShopController {

    private final BookShopService bookShopService;

    @Autowired
    public ShopController(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @GetMapping({"", "/books"})
    public String mainPage(Model model){
        model.addAttribute("bookData", bookShopService.getBooks());
        model.addAttribute("tagsInfo", bookShopService.getTags());
        return "index";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @GetMapping("/documents/index")
    public String documents() {
        return "documents/index";
    }
}
