package com.cactus.cquwl.Algorithm;

import java.util.List;
import java.util.Map;

import com.cactus.cquwl.pojo.CarSource;

public interface IOptimization {
	
	// 求最优组合
	// 参数说明: cars 汽车； targetGood 目标货物, count  是目标货物的个数
	public List<List<CarSource>> getOptimizationGroup(Map<Integer, List<CarSource>> maps, int target);
}
