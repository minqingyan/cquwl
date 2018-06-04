package com.cactus.cquwl.Algorithm;

import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;

public class ContextImp implements Context{

	private Strategy strategy;

	@Override
	public void setStrategy(Strategy strategy) {
		// TODO Auto-generated method stub
		this.strategy = strategy;
	}

	@Override
	public String algorithm(BasicGood bg, CarSource cs, BasicGood hbg, int count) {
		// TODO Auto-generated method stub
		return strategy.algorithm(bg, cs, hbg, count);
	}
}
