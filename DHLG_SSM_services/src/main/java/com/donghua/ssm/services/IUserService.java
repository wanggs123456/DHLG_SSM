package com.donghua.ssm.services;

import com.donghua.ssm.domain.Role;
import com.donghua.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);


    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId,String[] roleIds);
}
