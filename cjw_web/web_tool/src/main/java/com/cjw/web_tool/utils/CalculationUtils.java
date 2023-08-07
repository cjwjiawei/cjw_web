package com.cjw.web_tool.utils;

import com.cjw.web_tool.entity.SalaryEntity;

import java.math.BigDecimal;
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
     * 等额本金计算
     * @param money 总金额
     * @param lv 年利率
     * @param years 借贷时间/年
     */

    public static List<String> calculate (Double money,Double lv,Integer years){
        List<String> date= new ArrayList<>();
        //每月利率

        BigDecimal ratio = BigDecimal.valueOf(lv / 12);
        Integer month =years*12;
        DecimalFormat df = new DecimalFormat("#0.00");
        Double temp1=money;
        Double repay=0.0;
        //等额本金
        for (int i = 1; i <=month; i++) {

            //每个月应还本金
            double baseMoney =Double.parseDouble(df.format(money/month));

            Double currepay =Double.valueOf(df.format(baseMoney+(temp1*lv)));
            String str =String.format("第%s月应还:%s",i,currepay);
            date.add(str);
            System.out.println(str);
            repay+=currepay;

            temp1=Double.valueOf(df.format(temp1-baseMoney));
//            month--;
        }

        System.out.println("剩余本金"+temp1.toString());

        System.out.println("还款总金额"+repay);
        return date;
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
