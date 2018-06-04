package com.cactus.cquwl.Algorithm;

import java.util.List;
import java.util.Map;

import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;

public abstract class Strategy {

	// 计算该算法可以得到的箱子个数
	// hbg 是已经占用过的货物
	// count 就是已经占用货物的数量
	public abstract String algorithm(BasicGood bg, CarSource cs, BasicGood hbg, int count);
}
