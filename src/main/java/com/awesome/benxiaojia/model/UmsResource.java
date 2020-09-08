package com.awesome.benxiaojia.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UmsResource implements Serializable {
    private Long id;

    private Long categoryId;

    private Date createTime;

    private String name;

    private String url;

    private String value;

    private String description;

    private static final long serialVersionUID = 1L;

}
