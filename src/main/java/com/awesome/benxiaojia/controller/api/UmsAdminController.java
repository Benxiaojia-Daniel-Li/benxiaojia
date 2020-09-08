package com.awesome.benxiaojia.controller.api;

import com.awesome.benxiaojia.common.apihelper.CommonResult;
import com.awesome.benxiaojia.dto.UmsAdminLoginParam;
import com.awesome.benxiaojia.model.UmsResource;
import com.awesome.benxiaojia.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname UmsAdminController
 * @Description 用户管理apiController
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/8/21
 */
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/api/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.token-header}")
    private String tokenHeader;
    @Value("${jwt.token-head}")
    private String tokenHead;


    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>(16);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有资源权限")
    @RequestMapping(value = "/resource/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResource>> getResourceList(@PathVariable Long adminId) {
        List<UmsResource> umsResourceList= adminService.getResourceList(adminId);
        return CommonResult.success(umsResourceList);
    }


}
