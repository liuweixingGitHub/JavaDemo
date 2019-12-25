package com.ax.shop.controller;


import com.ax.shop.annotation.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiVersion
@RestController
@RequestMapping("/api/{version}")
public class TestController2 {

    @GetMapping("/testv")
    public String test01(@PathVariable String version) {
        return "test01 : " + version;
    }

    @GetMapping("/testv")
    @ApiVersion(2)
    public String test02(@PathVariable String version) {
        return "test02 : " + version;
    }

}

