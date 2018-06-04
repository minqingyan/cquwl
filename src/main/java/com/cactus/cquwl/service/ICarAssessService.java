package com.cactus.cquwl.service;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.pojo.CarAssess;

public interface ICarAssessService {

	public JSONObject readCarAssessById(String id);
	
	public JSONObject addCarAssess(String id,String orderId,CarAssess ca);
}
