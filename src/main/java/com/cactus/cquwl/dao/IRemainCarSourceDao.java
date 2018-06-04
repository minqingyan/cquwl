package com.cactus.cquwl.dao;

import com.cactus.cquwl.pojo.CarSource;
import com.cactus.cquwl.pojo.RemainCarSource;

public interface IRemainCarSourceDao {

	public RemainCarSource  findAvailableCarSource(CarSource cs, int state);
}
