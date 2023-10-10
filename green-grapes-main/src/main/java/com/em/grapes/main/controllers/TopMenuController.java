package com.em.grapes.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopMenuController {


    @GetMapping("/about")
    public String aboutUsPage(){
        return "pages/about";
    }

    @GetMapping("/contact")
    public String contactUsPage(){
        return "pages/contact";
    }

    @GetMapping("/devops")
    public String service(){
        return "pages/servicesPages/devops";
    }

    @GetMapping("/alm")
    public String alm(){
        return "pages/servicesPages/alm";
    }

}
