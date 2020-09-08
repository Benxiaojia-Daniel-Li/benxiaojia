package com.awesome.benxiaojia.mbg.mapper;

import com.awesome.benxiaojia.model.UmsResourceCategory;
import java.util.List;

public interface UmsResourceCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsResourceCategory record);

    UmsResourceCategory selectByPrimaryKey(Long id);

    List<UmsResourceCategory> selectAll();

    int updateByPrimaryKey(UmsResourceCategory record);
}