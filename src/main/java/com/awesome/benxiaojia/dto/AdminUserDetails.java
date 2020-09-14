package com.awesome.benxiaojia.dto;

import com.awesome.benxiaojia.model.UmsAdmin;
import com.awesome.benxiaojia.model.UmsResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 * Created by macro on 2018/4/26.
 */
public class AdminUserDetails implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsResource> umsResourceList;
    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsResource> umsResourceList) {
        this.umsAdmin = umsAdmin;
        this.umsResourceList = umsResourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return umsResourceList.stream()
                .filter(resource -> Objects.nonNull(resource))
                .filter(resource -> resource.getValue()!=null)
                .map(resource ->new SimpleGrantedAuthority(resource.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
