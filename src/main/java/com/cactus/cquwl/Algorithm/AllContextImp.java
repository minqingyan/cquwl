package com.cactus.cquwl.Algorithm;

import java.util.HashMap;
import java.util.Map;

import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;

public class AllContextImp implements AllContext{

	@Override
	public Map<Integer, String> availableMaxCount(BasicGood bg, CarSource cs, BasicGood hbg, int count) {
		// TODO Auto-generated method stub
		// 返回值为String类型
		// 使用一种字符串分隔的方式处理
		
		int lengthCount = 0;
		int widthCount = 0;
		int maxCount = 0;
		int weightCount = 0;
		
		String lengthStr = null;
		String widthStr = null;
		String weightStr = null;
	
		String maxStr = null; // 记录具体方案
		
		int availableMaxCount = 0;
		String availableMaxStr = null;
		
		Context context = new ContextImp();
		
		Strategy strategy = new ConcreteStrategyLengthCount();
		context.setStrategy(strategy);
		lengthStr = context.algorithm(bg, cs, hbg, count);
		lengthCount = Integer.parseInt(lengthStr.split("&")[0]);
		
		Strategy strategyHeight = new ConcreteStrategyWidthCount();
		context.setStrategy(strategyHeight);
		widthStr = context.algorithm(bg, cs, hbg, count);
		widthCount = Integer.parseInt(widthStr.split("&")[0]);
		
		maxCount = lengthCount > widthCount ? lengthCount : widthCount;
		maxStr = lengthCount > widthCount ? lengthStr : widthStr;
		
		Strategy strategyWeigth = new ConcreteStrategyWeigthCount();
		context.setStrategy(strategyWeigth);
		weightStr = context.algorithm(bg, cs, hbg, count);
		weightCount = Integer.parseInt(weightStr.split("&")[0]);
		
		availableMaxCount = maxCount > weightCount ? weightCount : maxCount;
		availableMaxStr = maxCount > weightCount ? weightStr : maxStr;
		
		System.out.println(cs.getCarNumber()+":"+lengthCount+"-"+widthCount+"-"+weightCount);
		System.out.println(cs.getCarNumber()+":"+availableMaxCount+"-"+availableMaxStr);
		
		Map<Integer, String> map = new HashMap<>();
		map.put(availableMaxCount, availableMaxStr);
		
		return map;
	}

	
}
