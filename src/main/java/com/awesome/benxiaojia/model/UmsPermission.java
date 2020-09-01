package com.awesome.benxiaojia.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UmsPermission implements Serializable {
    private Long id;

    private Long parentId;

    private String name;

    private String value;

    private String icon;

    private Boolean type;

    private String url;

    private Boolean status;

    private Date createTime;

    private Integer sort;

    private static final long serialVersionUID = 1L;


}
