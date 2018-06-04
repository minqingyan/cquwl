package com.cactus.cquwl.Algorithm;


import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;

public interface Context {
	
	public void setStrategy(Strategy strategy);
	
	public String algorithm(BasicGood bg, CarSource cs, BasicGood hbg, int count);
	
}
