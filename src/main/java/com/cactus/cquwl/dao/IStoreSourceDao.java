package com.cactus.cquwl.dao;

import java.util.List;

import com.cactus.cquwl.pojo.StoreSource;

public interface IStoreSourceDao {

	public StoreSource saveStoreSource(StoreSource store);
	
	public StoreSource findStoreSourceById(String id);
	
	public List<StoreSource> selectStoreSource(int state);
}
