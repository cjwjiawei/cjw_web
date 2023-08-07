package com.cjw.cjw_admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cjw.web_tool.utils.CalculationUtils;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calculate")
public class CalculteateController {

    @GetMapping("/doloan")
    public String doLoan(@RequestParam Double loan, Double apr, Integer years){
        List<String> calculate = CalculationUtils.calculate(loan, apr, years);
        Map<String,List> map= new HashMap<>();
        map.put("result",calculate);
//        JSONObject object;
        String s = JSON.toJSONString(map);

        return s;
    }
}
