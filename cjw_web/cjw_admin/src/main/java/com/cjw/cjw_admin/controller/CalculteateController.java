package com.cjw.cjw_admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cjw.cjw_admin.vo.CalculateVo;
import com.cjw.web_tool.utils.CalculationUtils;


import com.cjw.web_tool.utils.IpUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
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

    @PostMapping("/doloan2")
    public String doLoan2(@RequestBody CalculateVo calculateVo,HttpServletRequest request){

        String ipAddr = IpUtils.getIpAddr(request);
        System.out.println(ipAddr);
        Double apr = calculateVo.getApr();
        Double loan = calculateVo.getLoan();
        Double years = calculateVo.getYears();
        System.out.println();
        return "";
    }
}
