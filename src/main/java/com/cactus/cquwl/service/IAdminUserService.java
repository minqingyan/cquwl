package com.cactus.cquwl.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.pojo.AdminUser;

public interface IAdminUserService {
	
	public AdminUser readAdminUserById(int id);
	public AdminUser getUserByUserName(String username);
	public List<String> getPermissionsByUserName(String username);
	public AdminUser selectAdminUserByPhone(String phone);
	public AdminUser authenticat(String phone,String pwd) throws Exception;
	public AdminUser saveAdminUser(AdminUser user);
	
}
