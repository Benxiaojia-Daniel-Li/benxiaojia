package com.awesome.benxiaojia.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UmsRole implements Serializable {
    private Long id;

    private String roleName;

    private String description;

    private Date createTime;

    private Date updateTime;

    private Boolean status;

    private Integer sort;

    private static final long serialVersionUID = 1L;

}
