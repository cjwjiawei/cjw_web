package com.cjw.cjw_admin.vo;

import lombok.Data;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class CalculateVo {
    @NotBlank
    private Double loan;
    @NotBlank
    private Double apr;
    @NotBlank
    private Double years;

}
