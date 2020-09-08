package com.awesome.benxiaojia.mbg.mapper;

import com.awesome.benxiaojia.model.UmsResource;
import java.util.List;

public interface UmsResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsResource record);

    UmsResource selectByPrimaryKey(Long id);

    List<UmsResource> selectAll();

    int updateByPrimaryKey(UmsResource record);
}