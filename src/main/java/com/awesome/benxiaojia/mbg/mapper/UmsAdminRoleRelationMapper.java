package com.awesome.benxiaojia.mbg.mapper;

import com.awesome.benxiaojia.model.UmsAdminRoleRelation;
import java.util.List;

public interface UmsAdminRoleRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminRoleRelation record);

    UmsAdminRoleRelation selectByPrimaryKey(Long id);

    List<UmsAdminRoleRelation> selectAll();

    int updateByPrimaryKey(UmsAdminRoleRelation record);
}