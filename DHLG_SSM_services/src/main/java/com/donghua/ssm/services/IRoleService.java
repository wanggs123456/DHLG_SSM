package com.donghua.ssm.services;

import com.donghua.ssm.domain.Permission;
import com.donghua.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll();

    void save(Role role);

    Role findById(String roleId);

    void deleteRoleById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

     void addPermissionToRole(String roleId,String permissionIds);
}
