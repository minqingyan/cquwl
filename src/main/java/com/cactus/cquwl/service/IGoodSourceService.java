package com.cactus.cquwl.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.domain.entity.ResultCarMsg;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.BasicGood;

public interface IGoodSourceService {
	
	public List<ResultCarMsg> saveGoodSource(BasicGood good,AdminUser user);
	
	public JSONObject getGoodsTable(AdminUser user);
	
	public JSONObject getStoreGoodsTable(AdminUser user);
	
	public JSONObject getMyGoodsTable(AdminUser user);
	
	public JSONObject getMyStoreGoodsTable(AdminUser user);
	
	public String deleteGoodSource(String flag,String id);
}
