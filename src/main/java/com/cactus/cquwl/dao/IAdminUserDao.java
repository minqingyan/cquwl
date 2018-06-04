package com.cactus.cquwl.dao;

import com.cactus.cquwl.pojo.AdminUser;

public interface IAdminUserDao {
	
	AdminUser selectAdminUserById(int id);
	AdminUser findAdminUserByUserName(String name);
	AdminUser selectAdminUserByPhone(String phone);
	AdminUser saveAdminUser(AdminUser user);
}
