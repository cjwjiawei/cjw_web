package com.cjw.web_tool.entity;
import lombok.Data;

import java.util.List;

@Data
public class HouseLoan {

   private List<Loan> loans;
    /**
     * 总共应还贷款金额
     */
   private Double total;



   @Data
    public static class Loan{
        /**
         * 每月应还本金
         */
        private Double principal;
        /**
         * 每月还款利息
         */
        private Double interest;
        /**
         * 剩余本金
         */
        private Double surplusPrinciple;
        /**
         * 期次
         */
        private Integer issue;
       /**
        * 应还金额
        */
       private Double curRepay;

   }

}
