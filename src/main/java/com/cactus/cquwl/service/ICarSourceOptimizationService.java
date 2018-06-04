package com.cactus.cquwl.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.domain.entity.CarEasyMsg;
import com.cactus.cquwl.domain.entity.VehicleMsg;
import com.cactus.cquwl.pojo.AdminUser;

public interface ICarSourceOptimizationService {

	public List<List<CarEasyMsg>> getCarSourceTable(AdminUser user);
	
	public JSONObject getStoreGoodsTable(AdminUser user);
}
