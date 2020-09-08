package com.awesome.benxiaojia.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UmsMenu implements Serializable {
    private Long id;

    private Long parentId;

    private String title;

    private String name;

    private Integer level;

    private String icon;

    private String url;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private Integer sort;

    private static final long serialVersionUID = 1L;

}
