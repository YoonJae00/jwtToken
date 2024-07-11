package com.finalproject.jwttoken.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController {

    @GetMapping("/")
    public String mainP() {

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("name = " + name);
        return "main Controller";
    }
}