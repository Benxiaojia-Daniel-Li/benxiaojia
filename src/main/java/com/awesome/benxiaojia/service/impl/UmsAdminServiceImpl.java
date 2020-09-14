package com.awesome.benxiaojia.service.impl;

import com.awesome.benxiaojia.common.utils.JwtTokenUtil;
import com.awesome.benxiaojia.dao.UmsAdminRoleRelationDao;
import com.awesome.benxiaojia.mbg.mapper.UmsAdminMapper;
import com.awesome.benxiaojia.model.UmsAdmin;
import com.awesome.benxiaojia.model.UmsMenu;
import com.awesome.benxiaojia.model.UmsResource;
import com.awesome.benxiaojia.service.RedisService;
import com.awesome.benxiaojia.service.UmsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UmsAdminService实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.token-head}")
    private String tokenHead;
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;
    @Autowired
    private RedisService redisService;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin admin = umsAdminMapper.selectByName(username);
        if (admin != null) {
            return admin;
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
//        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
//        umsAdmin.setCreateTime(new Date());
//        umsAdmin.setStatus(1);
////        查询是否有相同用户名的用户
////        UmsAdminExample example = new UmsAdminExample();
////        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
////        List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(example);
////        if (umsAdminList.size() > 0) {
////            return null;
////        }
////        将密码进行加密操作
//        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
//        umsAdmin.setPassword(encodePassword);
//        umsAdminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //登录成功生成token
            token = jwtTokenUtil.generateToken(userDetails);
            //token写入redis
            redisService.set(userDetails.getUsername(),token);
            redisService.expire(userDetails.getUsername(),60);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId){
        return umsAdminRoleRelationDao.getResourceList(adminId);
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId){
        return umsAdminRoleRelationDao.getMenuList(adminId);
    }
}
