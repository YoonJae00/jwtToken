package com.finalproject.jwttoken.controller;

import com.finalproject.jwttoken.DTO.RegistDTO;
import com.finalproject.jwttoken.service.RegistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
public class RegistController {

    private final RegistService registService;

    public RegistController(RegistService registService) {

        this.registService = registService;
    }

    @PostMapping("/regist")
    public String joinProcess(RegistDTO registDTO) {

        System.out.println(registDTO.getUsername());
        registService.joinProcess(registDTO);

        return "ok";
    }
}
