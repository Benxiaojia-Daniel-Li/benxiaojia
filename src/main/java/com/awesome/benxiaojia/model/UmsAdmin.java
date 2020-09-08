package com.awesome.benxiaojia.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UmsAdmin implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String icon;

    private String email;

    private String cellphone;

    private String remark;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private Date loginTime;

    private static final long serialVersionUID = 1L;

}
