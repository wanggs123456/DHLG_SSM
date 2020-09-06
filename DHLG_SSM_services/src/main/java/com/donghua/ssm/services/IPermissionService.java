package com.donghua.ssm.services;

import com.donghua.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll();

    void save(Permission permission);

    Permission findById(String permissionId);

    void deleteById(String id) throws Exception;
}
