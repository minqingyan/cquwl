package com.cactus.cquwl.dao;

import java.util.List;

import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.MyOrders;

public interface ICarSourceOrderDao {

	public MyOrders saveOrder(MyOrders myorder);
	
	public List<MyOrders> findOrdersByUser(AdminUser user,int flag);
	
	public MyOrders findOrderById(String id);
	
}
