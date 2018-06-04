package com.cactus.cquwl.service;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.StoreGood;

public interface IStoreGoodService {

	public JSONObject saveStoreGood(StoreGood sg, AdminUser adminUser);
}
