package com.cactus.cquwl.dao;

import java.util.List;

import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;

public interface ICarSourceDao {

	public CarSource addCarMsg(CarSource cs);
	
	public List<CarSource> selectCarSourceList(int firstState, int endState);
	
	public CarSource findCarSourceById(String id);
	
	public List<CarSource> selectCarSourceListByBasicGood(BasicGood basicGood);
}
