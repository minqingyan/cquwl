package com.cactus.cquwl.dao;

import java.util.List;

import com.cactus.cquwl.pojo.StoreGood;

public interface IStoreGoodDao {

	public StoreGood addStoreGood(StoreGood sg);
	
	public StoreGood findStoreGood(String id);
	
	public List<StoreGood> selectStoreGoodList(int state);
	
	public void deleteStoreGood(String id);
}
