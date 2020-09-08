package com.awesome.benxiaojia.mbg.mapper;

import com.awesome.benxiaojia.model.UmsMenu;
import java.util.List;

public interface UmsMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsMenu record);

    UmsMenu selectByPrimaryKey(Long id);

    List<UmsMenu> selectAll();

    int updateByPrimaryKey(UmsMenu record);
}