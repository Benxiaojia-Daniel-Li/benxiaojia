package com.awesome.benxiaojia.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class UmsRolePermissionRelation implements Serializable {
    private Long id;

    private Long roleId;

    private Long permissionId;

    private static final long serialVersionUID = 1L;

}
