package com.awesome.benxiaojia.service;

import com.awesome.benxiaojia.model.UmsAdmin;
import com.awesome.benxiaojia.model.UmsMenu;
import com.awesome.benxiaojia.model.UmsResource;

import java.util.List;

/**
 * @Classname UmsAdminService
 * @Description 用户管理接口
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/8/21
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有资源权限
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 获取用户所有的菜单
     */
    List<UmsMenu> getMenuList(Long adminId);
}
