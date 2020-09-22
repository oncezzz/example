package com.zb.controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/***
 *
 * @author once
 * @date 2020/9/21 23:41
 *
 */
@RestController
public class RandomController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable int id) {
        return new Random().nextInt(id) + "";
    }

    public static void main(String[] args) {
        Assert.isTrue(false, "Base path must start with '/' or be empty");
    }
}
