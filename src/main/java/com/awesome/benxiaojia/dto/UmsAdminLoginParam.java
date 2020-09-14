package com.awesome.benxiaojia.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


/**
 * @Classname UmsAdminLoginParam
 * @Description 用户登录参数
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/8/21
 */
@Data
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

}
