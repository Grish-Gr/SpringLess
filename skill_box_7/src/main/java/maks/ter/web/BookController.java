package maks.ter.web;

import maks.ter.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {


    @GetMapping("/recent")
    public String recent(){
        return "books/recent";
    }

    @GetMapping("/popular")
    public String popular(){
        return "books/popular";
    }
}
