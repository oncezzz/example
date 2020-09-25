package com.example.springmobile.controller;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.site.SitePreference;
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

    @GetMapping("/device")
    public String device(Device device) {
        if (device.isMobile()) {
            return "hello mobile";
        } else if (device.isTablet()) {
            return "hello tablet";
        } else if (device.isNormal()){
            return "hello normal";
        }
        return "hello unknown";
    }

    @GetMapping("/preference")
    public String preference(SitePreference sitePreference) {
        if (sitePreference.isMobile()) {
            return "hello mobile";
        } else if (sitePreference.isTablet()) {
            return "hello tablet";
        } else if (sitePreference.isNormal()) {
            return "hello normal";
        }
        return "hello unknown";
    }
}
