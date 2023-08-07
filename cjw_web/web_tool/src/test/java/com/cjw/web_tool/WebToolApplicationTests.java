package com.cjw.web_tool;

import com.cjw.web_tool.entity.SalaryEntity;
import com.cjw.web_tool.utils.CalculationUtils;

import java.math.BigDecimal;


class WebToolApplicationTests {

    public static void main(String[] args) {
        SalaryEntity salaryEntity= new SalaryEntity();
        Double [] insurecace ={640.00,40.00,163.00,960.00};
        salaryEntity.setInsurance(insurecace);
        salaryEntity.setRatio(0.03);
        salaryEntity.setTaxes(79.34);
        Double aDouble = CalculationUtils.insuranceCalculator(salaryEntity);
//        System.out.println(aDouble);

        CalculationUtils.calculate(60000.0,0.003,1);
        BigDecimal s =new BigDecimal(12);
        BigDecimal a= new BigDecimal(0.4);
        double v = a.divide(s, 4,BigDecimal.ROUND_UP).doubleValue();
        System.out.println(v);
    }

    void contextLoads() {
    }

}
