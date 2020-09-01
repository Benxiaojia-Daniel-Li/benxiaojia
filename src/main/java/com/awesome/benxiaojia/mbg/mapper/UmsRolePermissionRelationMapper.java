package com.awesome.benxiaojia.mbg.mapper;

import com.awesome.benxiaojia.model.UmsRolePermissionRelation;
import java.util.List;

public interface UmsRolePermissionRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsRolePermissionRelation record);

    UmsRolePermissionRelation selectByPrimaryKey(Long id);

    List<UmsRolePermissionRelation> selectAll();

    int updateByPrimaryKey(UmsRolePermissionRelation record);
}