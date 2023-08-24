package com.cjw.cjw_admin.controller;

import com.alibaba.fastjson.JSON;
import com.cjw.cjw_admin.vo.AjaxResult;
import com.cjw.cjw_admin.vo.CalculateVo;
import com.cjw.web_tool.entity.HouseLoan;
import com.cjw.web_tool.utils.CalculationUtils;


import com.cjw.web_tool.utils.IpUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calculate")
public class CalculteateController {

    @GetMapping("/doloan")
    public String doLoan(@RequestParam Double loan, Double apr, Integer years){
        HouseLoan calculate = CalculationUtils.calculate(loan, apr, years);
        Map<String,List> map= new HashMap<>();
//        map.put("result",calculate);
//        JSONObject object;
        String s = JSON.toJSONString(map);

        return s;
    }

    @PostMapping("/doloan2")
    @ResponseBody
    public String doLoan2(@RequestBody @Validated CalculateVo calculateVo, HttpServletRequest request){

        String ipAddr = IpUtils.getIpAddr(request);
        System.out.println(ipAddr);
        Double apr = Double.valueOf(calculateVo.getApr());
        Double loan = Double.valueOf(calculateVo.getLoan());
        Integer years = calculateVo.getYears();
        HouseLoan calculate = CalculationUtils.calculate(loan, apr, years);


        return AjaxResult.seccess(calculate);
    }
}
