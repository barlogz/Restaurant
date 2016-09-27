package ua.goit.java.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestController {
    @RequestMapping("/rest")
    public String index() {
        return "rest";
    }
}