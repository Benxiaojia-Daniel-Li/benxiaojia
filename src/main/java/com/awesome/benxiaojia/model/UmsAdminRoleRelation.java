package com.awesome.benxiaojia.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UmsAdminRoleRelation implements Serializable {
    private Long id;

    private Long adminId;

    private Long roleId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

}
