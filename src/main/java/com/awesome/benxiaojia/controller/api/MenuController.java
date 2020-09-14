package com.awesome.benxiaojia.controller.api;

import com.awesome.benxiaojia.service.MenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname MenuController
 * @Description TODO
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/9/8
 */
@Controller
@RequestMapping("api/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    @RequestMapping(value = "/{adminId}",method = RequestMethod.GET)
    @ResponseBody
    public String getMenu(@PathVariable Long adminId ) throws JsonProcessingException {

//        return menuService.getMenuList(adminId).toString();
        return menuService.getMenu2Json(adminId);
    }

}
