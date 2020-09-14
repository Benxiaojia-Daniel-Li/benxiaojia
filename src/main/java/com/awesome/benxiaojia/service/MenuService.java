package com.awesome.benxiaojia.service;

import com.awesome.benxiaojia.model.UmsMenu;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

/**
 * @Classname MenuService
 * @Description TODO
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/9/8
 */
public interface MenuService {

    List<UmsMenu> getMenuList (Long id);

    String getMenu2Json (Long adminId) throws JsonProcessingException;

}
