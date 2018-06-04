package com.cactus.cquwl.service;

import java.text.ParseException;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.pojo.AdminUser;

public interface ICarSourceOrderService {

	public JSONObject saveOrdering(AdminUser adminUser,String id,int flag) throws ParseException;
	
	public JSONObject findOrderByUser(AdminUser user,int flag);
	
	public String findOrderById(String orderId);
	
	public JSONObject saveOrderingAndChangeGood(AdminUser adminUser,String id,int flag);
}
