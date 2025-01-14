package com.nail.decoplanner.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class website_Controller {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
