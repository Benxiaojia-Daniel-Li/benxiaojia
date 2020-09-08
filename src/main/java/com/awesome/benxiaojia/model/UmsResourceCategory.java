package com.awesome.benxiaojia.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class UmsResourceCategory implements Serializable {
    private Long id;

    private Date createTime;

    private String name;

    private Integer sort;

    private static final long serialVersionUID = 1L;

}
