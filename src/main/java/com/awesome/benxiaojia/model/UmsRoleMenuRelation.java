package com.awesome.benxiaojia.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UmsRoleMenuRelation implements Serializable {
    private Long id;

    private Long roleId;

    private Long menuId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

}
