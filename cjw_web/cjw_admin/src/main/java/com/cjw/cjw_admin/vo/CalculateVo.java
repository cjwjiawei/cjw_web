package com.cjw.cjw_admin.vo;

import lombok.Data;


import javax.validation.constraints.NotBlank;


@Data
public class CalculateVo {
    @NotBlank
    private String loan;
    @NotBlank
    private String apr;
    @NotBlank
    private Integer years;

}
