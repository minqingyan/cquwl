package com.cactus.cquwl.dao;

import java.util.List;

import com.cactus.cquwl.pojo.AdminPermission;

public interface IAdminUserPermissionDao {

	List<AdminPermission>  findPermissionById(int id);
}
