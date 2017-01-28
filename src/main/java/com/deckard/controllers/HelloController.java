package com.deckard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {
    @RequestMapping("/pow")
    public String pow(@RequestParam("number")int number){
        double n = Math.pow((double)number,2);
        return String.valueOf(n);
    }
}
