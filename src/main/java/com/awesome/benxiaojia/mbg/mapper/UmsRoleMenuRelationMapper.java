package com.awesome.benxiaojia.mbg.mapper;

import com.awesome.benxiaojia.model.UmsRoleMenuRelation;
import java.util.List;

public interface UmsRoleMenuRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsRoleMenuRelation record);

    UmsRoleMenuRelation selectByPrimaryKey(Long id);

    List<UmsRoleMenuRelation> selectAll();

    int updateByPrimaryKey(UmsRoleMenuRelation record);
}