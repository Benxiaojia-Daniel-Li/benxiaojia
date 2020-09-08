package com.awesome.benxiaojia.dao;



import com.awesome.benxiaojia.model.UmsMenu;
import com.awesome.benxiaojia.model.UmsResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 * Created by macro on 2018/10/8.
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有资源权限
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有的菜单
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
}
