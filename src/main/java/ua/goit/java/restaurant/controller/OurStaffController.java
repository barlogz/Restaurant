package ua.goit.java.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OurStaffController {

    @RequestMapping(value = "/ouremployees/list", method = RequestMethod.GET)
    public String showAll() {
        return "/ouremployees/list";
    }
}
