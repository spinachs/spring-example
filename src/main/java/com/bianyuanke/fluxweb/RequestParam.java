package com.bianyuanke.fluxweb;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 马良
 * @since 2019-03-13
 */
@Data
public class RequestParam {
    @NotBlank(message = "姓名不能为空")
    private String name;
}
