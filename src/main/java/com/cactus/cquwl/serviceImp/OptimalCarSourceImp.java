package com.cactus.cquwl.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cactus.cquwl.Algorithm.AllContext;
import com.cactus.cquwl.Algorithm.AllContextImp;
import com.cactus.cquwl.dao.ICarSourceDao;
import com.cactus.cquwl.dao.IRemainCarSourceDao;
import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;
import com.cactus.cquwl.pojo.RemainCarSource;
import com.cactus.cquwl.service.IOptimalCarSource;

public class OptimalCarSourceImp implements IOptimalCarSource{

	@Autowired
	private ICarSourceDao carSourceDao;
	
	@Autowired
	private IRemainCarSourceDao remainCarSourceDao;
	
	// 计算最优载重箱子个数
	/*
	 * 按照算法一：横着摆放可以摆放的最多箱子个数n1 ；
	 * 按照算法二：竖着摆放可以摆放的最多箱子个数n2；
	 * 以上两种算法得到最大箱子个数 n
	 * 按照算法三: 按照最大载重可以摆放箱子的个数 m；
	 * 求 n 与 m 的最小数
	 */
	@Override
	public JSONObject getOptimalCarSourceByGoodSource(BasicGood  bg) {
		// TODO Auto-generated method stub
		// 先读取所有空闲的车辆
		List<CarSource> cars = carSourceDao.selectCarSourceList(1,2);
		AllContext context = new AllContextImp();
		
		int availableMaxCount = 0;
		int size = cars.size(); // 
		
		int[] maxCount = new int[size];
		CarSource[] carSource = new CarSource[size];
		int i=0;
		for(CarSource car : cars){
			if(car.getState() == 2){
				// 状态为2 的是拼车
				// 读取拼车信息
				RemainCarSource rcs = remainCarSourceDao.findAvailableCarSource(car, 1);
				// 计算
				//availableMaxCount = context.availableMaxCount(bg, car, rcs.getBasicGood(), rcs.getCount());
				
				maxCount[i++] = availableMaxCount;
				carSource[i++] = car;
			}
		}
		// 进行计算
		
		
		return null;
	}

}
