package com.cjw.web_tool.entity;

import lombok.Data;

/**
 * @Author jiawei
 * @Date 2023/7/21 10:38
 * @Vsersion
 * @Desc
 */
@Data
public class SalaryEntity {

    private Double []insurance;//保险（五险一金）

    private Double ratio;// 上税比率
    private Double taxes;//所缴纳税金额
    private Double base=5000.0;//本金


}
