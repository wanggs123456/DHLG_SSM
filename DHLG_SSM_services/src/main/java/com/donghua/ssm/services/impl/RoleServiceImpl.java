package com.donghua.ssm.services.impl;

import com.donghua.ssm.dao.IRoleDao;
import com.donghua.ssm.domain.Permission;
import com.donghua.ssm.domain.Role;
import com.donghua.ssm.services.IRoleService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return  roleDao.findAll();

    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);

    }

    @Override
    public void deleteRoleById(String roleId) {
        roleDao.deleteRoleById(roleId);
        roleDao.deleteFromrole_permissionByRoleId(roleId);
        roleDao.deleteFromusers_roleByRoleId(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String permissionIds) {
        roleDao.addPermissionToRole(roleId,permissionIds);
    }
}
