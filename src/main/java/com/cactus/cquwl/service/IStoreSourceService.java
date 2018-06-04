package com.cactus.cquwl.service;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.StoreSource;

public interface IStoreSourceService {
	
	public void saveStoreSource(StoreSource store,AdminUser user);

	public JSONObject selectStoreSource(int state,AdminUser user);
}
