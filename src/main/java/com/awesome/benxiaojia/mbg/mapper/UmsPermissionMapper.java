package com.awesome.benxiaojia.mbg.mapper;

import com.awesome.benxiaojia.model.UmsPermission;
import java.util.List;

public interface UmsPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsPermission record);

    UmsPermission selectByPrimaryKey(Long id);

    List<UmsPermission> selectAll();

    int updateByPrimaryKey(UmsPermission record);
}