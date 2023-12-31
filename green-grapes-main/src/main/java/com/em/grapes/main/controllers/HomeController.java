package com.em.grapes.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


    @GetMapping
    public String home(@RequestParam(name = "logout", required = false, defaultValue = "true") boolean logout) {
        return "index";
    }
    
    @GetMapping(path = {"/placements", "/placements/"})
    public String placements(@RequestParam(name = "logout", required = false, defaultValue = "true") boolean logout) {
        return "placements";
    }

    @GetMapping("/login")
    String login() {
        return "app-user/login";
    }
}
