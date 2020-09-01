package com.awesome.benxiaojia.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Classname UmsAdminPageController
 * @Description 用户管理pageController
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/8/21
 */
@Controller
@RequestMapping("/admin")
public class UmsAdminPageController {

    /**
     * 返回登录页面
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "admin/login";
    }

    /**
     * 返回系统主页面
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){

        return "admin/index";
    }
}
