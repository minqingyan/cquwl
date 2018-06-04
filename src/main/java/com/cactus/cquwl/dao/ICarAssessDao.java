package com.cactus.cquwl.dao;

import com.cactus.cquwl.pojo.AllCarAssess;
import com.cactus.cquwl.pojo.CarAssess;
import com.cactus.cquwl.pojo.CarSource;

public interface ICarAssessDao {

	public AllCarAssess readCarAssessById(CarSource car);

	public AllCarAssess addAllCarAssess(AllCarAssess allCarAssess);
	
	public CarAssess addCarAssess(CarAssess ca);
	

}
