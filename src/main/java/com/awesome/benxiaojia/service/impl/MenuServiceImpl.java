package com.awesome.benxiaojia.service.impl;


import com.awesome.benxiaojia.dao.UmsAdminRoleRelationDao;
import com.awesome.benxiaojia.dto.MenuParam;
import com.awesome.benxiaojia.model.UmsMenu;
import com.awesome.benxiaojia.service.MenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname MenuServiceImpl
 * @Description TODO
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/9/8
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;

    @Override
    public List<UmsMenu> getMenuList (Long adminId){

        return umsAdminRoleRelationDao.getMenuList(adminId);
    }
    @Override
    public String getMenu2Json (Long adminId) throws JsonProcessingException {
        MenuParam menuParam = new MenuParam();
        //获取菜单数据
        List<UmsMenu> umsMenuList = umsAdminRoleRelationDao.getMenuList(adminId);
        //把菜单数据转为树形结构
        List<MenuParam.SubMenu> menuParamList = this.list2Tree(0,umsMenuList,umsMenuList);
        // 首页数据
        MenuParam.SubMenu homeInfo = new MenuParam.SubMenu();
        homeInfo.setTitle("首页");
        homeInfo.setHref("page/welcome-1.html?t=1");
        menuParam.setHomeInfo(homeInfo);
        // logo数据
        MenuParam.SubMenu logoInfo = new MenuParam.SubMenu();
        logoInfo.setTitle("测试");
        logoInfo.setImage("images/logo.png");
        logoInfo.setHref("");
        menuParam.setLogoInfo(logoInfo);
        //全部菜单数据
        menuParam.setMenuInfo(menuParamList);
        return new ObjectMapper().writeValueAsString(menuParam);
    }


    private List<MenuParam.SubMenu>  list2Tree (long parentId,List<UmsMenu> originalMenu, List<UmsMenu> menuStream) {
        //初始化菜单
        List<MenuParam.SubMenu> menuList = new ArrayList<>();
        //查询没有数据则退出
        if (null == menuStream && menuStream.size() == 0) {
            return menuList;
        }
        //根据父节点查询子菜单数据
        menuStream = originalMenu.stream()
                .filter(resource -> resource.getParentId() == parentId)
                .collect(Collectors.toList());
        if (null != menuStream && menuStream.size() > 0) {
            //遍历子菜单，设置菜单数据
            for (UmsMenu menu : menuStream) {
                MenuParam.SubMenu subMenu = new MenuParam.SubMenu();
                subMenu.setTitle(menu.getTitle());
                subMenu.setHref(menu.getUrl());
                //递归查询子菜单，如果有则设置child节点
                List<MenuParam.SubMenu> childMenu = list2Tree(menu.getId(), originalMenu, menuStream);
                if (null != childMenu && childMenu.size()>0) {
                    subMenu.setChild(childMenu);
                }
                //把结果添加到菜单
                menuList.add(subMenu);
            }
        }
        return menuList;
    }

}
