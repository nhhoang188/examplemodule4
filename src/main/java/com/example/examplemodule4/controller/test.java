package com.example.examplemodule4.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class test {

    @GetMapping
    public ModelAndView test(@PageableDefault(size = 2) Pageable pageable) {
        return new ModelAndView("/index");
    }
}
