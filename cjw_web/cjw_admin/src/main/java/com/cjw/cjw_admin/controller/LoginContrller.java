package com.cjw.cjw_admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/cjw_web")
public class LoginContrller {

    @RequestMapping("/login")
    public String login(){

        String str ="sjko";

        return str;
    }
}
