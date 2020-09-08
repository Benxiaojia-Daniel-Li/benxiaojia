package com.awesome.benxiaojia.mbg.mapper;

import com.awesome.benxiaojia.model.UmsRoleResourceRelation;
import java.util.List;

public interface UmsRoleResourceRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsRoleResourceRelation record);

    UmsRoleResourceRelation selectByPrimaryKey(Long id);

    List<UmsRoleResourceRelation> selectAll();

    int updateByPrimaryKey(UmsRoleResourceRelation record);
}