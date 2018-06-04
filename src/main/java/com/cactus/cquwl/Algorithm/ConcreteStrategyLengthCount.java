package com.cactus.cquwl.Algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;

/*
 * 算法一：
 * 箱子横着摆放，最多可以摆多少个
 * 思想如下：
 * 箱子length为l，width为w,height为h； 车子length为lc,width为wc,heigth为hc;
 * length方向可以放置nl=lc/l 个箱子；
 * width 方向可以放置nw=wc/w 个箱子
 * 一层可以放置 nl*nw 个箱子
 * 另外，考虑length方向 的箱子没有放满的空间可以放置转向的箱子的情况
 * 如果 lc-nl*l > w && wc > l, 则可以放置箱子, 可以放置  ( (lc-nl*l)/w ) * ( wc/l )个箱子;
 * 因此一层总的可以放置 nl * nw +  ( (lc-nl*l)/w ) * ( wc/l ) 个箱子
 * 按照车子的高度和箱子的高度， 
 * 如果 hc < h 放置不下
 * 否则： 可以放置 hc / h 层
 * 
 */
public class ConcreteStrategyLengthCount extends Strategy{

	private static final String stragemsg1 = "摆放方案一";
	private static final String stragemsg3 = "摆放方案三";
	private static final String stragepic1 = "assets/img/stragepic/201612141112381.png";
	private static final String stragepic3 = "assets/img/stragepic/201612141112383.png";
	
	@Override
	public String algorithm(BasicGood bg, CarSource cs, BasicGood hbg, int count) {
		// TODO Auto-generated method stub
		Map<CarSource,Integer> map = new HashMap<>();
		float l = bg.getUnitLength();
		float w = bg.getUnitWidth();
		float h = bg.getUnitHeight();
		
		String strage = null;
			
		int allCount = 0;
		float lc =  0f;
		float wc = 0f;
		float hc = 0f;
		if(hbg == null){
			lc = cs.getCarLength();
			wc = cs.getCarWidth();
			hc = cs.getCarHeigth();
		}else{
			lc = cs.getCarLength() - hbg.getUnitLength() * count;
			wc = cs.getCarWidth() - hbg.getUnitWidth() * count;
			hc = cs.getCarHeigth() - hbg.getUnitHeight() * count;
		}
		
		int nl = (int) (lc/l);
		int nw = (int) (wc/w);
		
		int addition = 0; 
		
		if((lc - nl * l) >= w && (wc >= l))
			addition =  (int)((lc - nl * l ) / w) * (int)( wc / l );
		
		if(hc < h)
			return allCount + "&" + "" + "&" + "";
		else{
			allCount = ( nl * nw + addition ) * (int)(hc / h);
			if(addition == 0){
				strage = stragemsg1 + "&" + "(" + nl + "x" + nw + ")x" +  (int)(hc / h) + "&" + stragepic1;
			}else {
				strage = stragemsg3 + "&" + "(" + nl + "x" + nw +"+"+ addition + ")x" +  (int)(hc / h) + "&" +stragepic3;
			}
			return allCount + "&" + strage ;
		}
	}
}
