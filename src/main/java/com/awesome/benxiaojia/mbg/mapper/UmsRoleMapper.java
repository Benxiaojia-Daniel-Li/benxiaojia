package com.awesome.benxiaojia.mbg.mapper;

import com.awesome.benxiaojia.model.UmsRole;
import java.util.List;

public interface UmsRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsRole record);

    UmsRole selectByPrimaryKey(Long id);

    List<UmsRole> selectAll();

    int updateByPrimaryKey(UmsRole record);
}