package com.cactus.cquwl.service;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.pojo.BasicGood;

public interface IOptimalCarSource {

	// 计算最优载重箱子个数
	/*
	 * 按照算法一：横着摆放可以摆放的最多箱子个数n1 ；
	 * 按照算法二：竖着摆放可以摆放的最多箱子个数n2；
	 * 以上两种算法得到最大箱子个数 n
	 * 按照算法三: 按照最大载重可以摆放箱子的个数 m；
	 * 求n 与 m 的最小数
	 */
	public JSONObject getOptimalCarSourceByGoodSource(BasicGood bg);
}
