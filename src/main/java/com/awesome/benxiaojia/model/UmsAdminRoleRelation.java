package com.awesome.benxiaojia.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class UmsAdminRoleRelation implements Serializable {
    private Long id;

    private Long adminId;

    private Long roleId;

    private static final long serialVersionUID = 1L;


}
