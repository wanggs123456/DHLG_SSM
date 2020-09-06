package com.donghua.ssm.dao;

import com.donghua.ssm.domain.Permission;
import com.donghua.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    //根据用户id查询所有对应的用户角色
    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.donghua.ssm.dao.IPermissionDao.findPermissionByRoleId")),
    })
    public List<Role> findRoleByUserId(String userId);

    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

   @Select("select * from role where id=#{roleId}")
   @Results({
           @Result(id = true,property = "id",column = "id"),
           @Result(property = "roleName",column = "roleName"),
           @Result(property = "roleDesc",column = "roleDesc"),
           @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.donghua.ssm.dao.IPermissionDao.findPermissionByRoleId"))
   })
   Role findById(String roleId);


   @Delete("delete  from role where id=#{roleId}")
    void deleteRoleById(String roleId);
   @Delete("delete from role_permission where roleId=#{roleId}")
   void deleteFromrole_permissionByRoleId(String roleId);
   @Delete("delete from users_role where roleId=#{roleId}")
    void deleteFromusers_roleByRoleId(String roleId);

   @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{roleId})")
   List<Permission> findOtherPermissions(String roleId);

   @Insert("insert into role_permission (roleId,permissionId) values(#{roleId},#{permissionId})")
   void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionIds);
}
