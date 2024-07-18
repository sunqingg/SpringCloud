package com.atguigu.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class payController {

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") Integer id) {
        return Integer.toString(id) +"test3377";
    }
}
