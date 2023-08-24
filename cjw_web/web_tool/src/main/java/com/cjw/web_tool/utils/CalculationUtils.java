package com.cjw.web_tool.utils;

import com.cjw.web_tool.entity.HouseLoan;
import com.cjw.web_tool.entity.SalaryEntity;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author jiawei
 * @Date 2023/7/21 10:28
 * @Vsersion
 * @Desc
 */
public class CalculationUtils {


    /**
     *
     * @param entity  封装类
     * @return 返回税前工资金额
     */
    public static Double insuranceCalculator(SalaryEntity entity){

        Double salary ;
        Double sum =entity.getBase();
        if (entity.getInsurance().length<=0){
            return 0.00;
        }
        if (entity.getRatio()>1){
            entity.setRatio(entity.getRatio()/100f);
        }

        for (Double aDouble : entity.getInsurance()) {
            sum+=aDouble;
        }
        Double temp = sum*entity.getRatio()+entity.getTaxes();
        salary=temp/entity.getRatio();
        BigDecimal result=new BigDecimal(salary);
        salary=result.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return salary;
    }

    /**
     * 房贷计算器
     * 等额本金计算
     * 计算公式：
     * 每月应还本金=本金/总期次
     * 利息=本金*每月利率
     * 还款额=本金+利息
     *
     * @param loan 总金额
     * @param apr 年利率
     * @param years 借贷时间/年
     */

    public static HouseLoan calculate (Double loan, Double apr, Integer years){

        HouseLoan houseLoan =new HouseLoan();
        List<HouseLoan.Loan> loanList = new ArrayList<>();

        //每月利率
        apr =BigDecimal.valueOf(apr)
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
//            String str ="第"+loans.getIssue()+"期，应还本金"+loans.getPrincipal()+", 应还利息"+loans.getInterest()+
//                    ", 应还金额"+loans.getCurRepay()+" 剩余本金"+loans.getSurplusPrinciple();

            loanList.add(loans);
//            System.out.println(str);
        }

        houseLoan.setLoans(loanList);
        houseLoan.setTotal(resultMoney);
        return houseLoan;
    }

    /**
     * @descrption 等额本息计算器
     * @param loan
     * @param apr
     * @param years
     * @return
     */
    public static List<Double> calculater(Double loan,Double apr,Integer years){

        Integer month = years*12;
        //每个月的月利率
        BigDecimal mpr =BigDecimal.valueOf(apr);
        mpr.divide(BigDecimal.valueOf(12),4,BigDecimal.ROUND_UP);

        // 计算每个月所需要的金额
        for (int i = 1; i <=month; i++) {

            //每个月应还的本金
            double baseMoney =
                    BigDecimal.valueOf(loan).divide(BigDecimal.valueOf(month), 2, BigDecimal.ROUND_UP).doubleValue();

        }

        List<Double> monthlyMoney=new ArrayList<>();

        return monthlyMoney;

    }

}
