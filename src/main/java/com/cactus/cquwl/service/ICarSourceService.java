package com.cactus.cquwl.service;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.CarSource;

public interface ICarSourceService {

	public void addCarMsg(CarSource car,AdminUser user);
	
	public JSONObject selectCarTable(AdminUser user);
	
	public String findCarById(String id);
	
}
