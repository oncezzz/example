package com.example.springmobile.controller;

import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @author once
 * @date 2020/9/26 0:44
 *
 */
@RestController
public class LoginController {

    @GetMapping("/get")
    public String get(Device device) {
        if (device.isMobile()) {
            return "hello mobile";
        } else if (device.isTablet()) {
            return "hello tablet";
        } else if (device.isNormal()){
            return "hello normal";
        }
        return "hello unknown";
    }
}
