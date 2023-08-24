package com.cjw.web_tool;


import com.cjw.web_tool.entity.HouseLoan;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalculateTest {
    @Test
    public void  test01(){
        Double loan =600000.00;
        //每月利率
        Double apr =BigDecimal.valueOf(4)
                .divide(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(12),5,BigDecimal.ROUND_DOWN).doubleValue();
        Integer mouthly = 60;
        Double surplusPrinciple =loan;
        Double resultMoney=0.00;

        //每月应还本金
        double mothlyRepayMoney = BigDecimal.valueOf(loan).divide(BigDecimal.valueOf(mouthly), 2,BigDecimal.ROUND_DOWN).doubleValue();

        for (int i = 1; i <=mouthly ; i++) {

            HouseLoan.Loan loans = new HouseLoan.Loan();
            loans.setPrincipal(mothlyRepayMoney);
            Double interest = BigDecimal.valueOf(surplusPrinciple).multiply(BigDecimal.valueOf(apr)).setScale(2,BigDecimal.ROUND_DOWN).doubleValue();
            loans.setInterest(interest);
            double v = BigDecimal.valueOf(mothlyRepayMoney).multiply(BigDecimal.valueOf(i)).doubleValue();
            surplusPrinciple=BigDecimal.valueOf(loan).subtract(BigDecimal.valueOf(v)).setScale(2,BigDecimal.ROUND_DOWN).doubleValue();
            loans.setSurplusPrinciple(surplusPrinciple);
            double curRepay = BigDecimal.valueOf(mothlyRepayMoney).add(BigDecimal.valueOf(interest), MathContext.UNLIMITED).doubleValue();
            loans.setCurRepay(curRepay);
            loans.setIssue(i);

            resultMoney=BigDecimal.valueOf(resultMoney).add(BigDecimal.valueOf(curRepay)).doubleValue();
            String str ="第"+loans.getIssue()+"期，应还本金"+loans.getPrincipal()+", 应还利息"+loans.getInterest()+
                    ", 应还金额"+loans.getCurRepay()+" 剩余本金"+loans.getSurplusPrinciple();

            System.out.println(str);


        }

        double v = BigDecimal.valueOf(600000).divide(BigDecimal.valueOf(23),2,BigDecimal.ROUND_DOWN).doubleValue();
        System.out.println(resultMoney);


    }
}
