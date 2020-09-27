package com.example.springmobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/***
 *
 * @author once
 * @date 2020/9/27 20:46
 *
 */
@Controller
public class ViewController {

    @GetMapping("/view")
    public String view() {
        return "index";
    }
}
