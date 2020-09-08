package com.awesome.benxiaojia.component;

import cn.hutool.json.JSONUtil;
import com.awesome.benxiaojia.common.apihelper.CommonResult;
import com.awesome.benxiaojia.common.utils.JudgeIsCellphoneUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当未登录或者token失效访问接口时，自定义的返回结果
 * Created by macro on 2018/5/14.
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException  {

        if(JudgeIsCellphoneUtil.isCellphoneBrowser(request)){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(authException.getMessage())));
            response.getWriter().flush();
        } else {

            //当验证token失败的时候，重定向到登录页面，并重置token
            Cookie cookie = new Cookie("Bearer", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect("/admin/login");
        }


    }
}
