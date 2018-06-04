package com.cactus.cquwl.Algorithm;

import java.util.Map;

import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;

public interface AllContext {
	
	public  Map<Integer, String> availableMaxCount(BasicGood bg, CarSource cs, BasicGood hbg, int count);
	
}
