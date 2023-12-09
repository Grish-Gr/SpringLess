package maks.ter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tags")
public class TagController {

    @GetMapping("/{tag}")
    public String recent(@PathVariable String tag){
        return "tags/index";
    }

}
