package com.cactus.cquwl.Algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;

/*
 * 算法三
 * 箱子按照摆放，最多可以摆放多少个
 * 思想如下：
 * 箱子的重量：w
 * 车子最大载重 wc
 * 在不考虑是否体积的情况下，最多可以装载wc/w个箱子
 */
public class ConcreteStrategyWeigthCount extends Strategy{

	private static final String stragemsg = "摆放方案一/二";
	private static final String stragepic1 = "assets/img/stragepic/201612141112381.png";
	
	@Override
	public String algorithm(BasicGood bg, CarSource cs, BasicGood hbg, int count) {
		// TODO Auto-generated method stub
		
		float w = bg.getUnitWeight();
		int allCount = 0;
		float wc = 0f;
		
		if(hbg == null){
			wc = cs.getWeight();
		}else{
			wc = cs.getWeight() - hbg.getUnitWeight() * count;
		}
		allCount = (int) (wc / w);
		
		return allCount + "&" + stragemsg + "&" + "方案一或者二" + "&" + stragepic1;
	}
}
