package com.awesome.benxiaojia.mbg.mapper;

import com.awesome.benxiaojia.model.UmsAdmin;
import java.util.List;

public interface UmsAdminMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    List<UmsAdmin> selectAll();

    int updateByPrimaryKey(UmsAdmin record);

    UmsAdmin selectByName(String username);

}
