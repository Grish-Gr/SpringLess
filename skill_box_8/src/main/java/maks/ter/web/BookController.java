package maks.ter.web;

import maks.ter.service.BookShopService;
import maks.ter.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/recent")
    public String recent(){
        return "books/recent";
    }

    @GetMapping("/popular")
    public String popular(){
        return "books/popular";
    }

    @GetMapping("/{id}")
    public String popular(@PathVariable Long id, Model model){
        model.addAttribute("book", booksService.getBook(id));
        return "books/slug";
    }
}
