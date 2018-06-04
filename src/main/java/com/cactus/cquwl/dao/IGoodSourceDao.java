package com.cactus.cquwl.dao;

import java.util.List;

import com.cactus.cquwl.pojo.AdminUser;
import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.StoreGood;

public interface IGoodSourceDao {

	// 使用insert 语句自动生成主键策略，需要有返回值，返回主键
	BasicGood saveGoodSource(BasicGood good);
	
	List<BasicGood> getGoodSource(int state);
	
	BasicGood findGoodSource(String id);
	
	List<BasicGood> getMyGoodSource(int state, AdminUser adminUser);
	
	List<StoreGood> getMyStoreGoodSource(int state, AdminUser adminUser);
	
	public void deleteGood(String id);
}
