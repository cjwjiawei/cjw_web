package com.cjw.cjw_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
public class HelloController {

    @RequestMapping("/tools")
    public String index(){
        System.out.println("hellot");
        return "tools/tools";

    }
}
