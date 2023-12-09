package maks.ter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/postponed")
public class PostponedController {

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "postponed/index";
    }
}
