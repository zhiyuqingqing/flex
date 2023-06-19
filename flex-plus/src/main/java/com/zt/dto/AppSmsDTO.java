package com.zt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 客户端请求验证码
 *
 * @author lengleng
 * @date 2022/10/13
 */
@Data
@ApiModel
public class AppSmsDTO {

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号", hidden = true)
    private String phone;
    @ApiModelProperty(value = "手机号是否存在")
    /**
     * 手机号是否存在数据库
     */
    private Boolean exist;

}
