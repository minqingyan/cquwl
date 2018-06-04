package com.cactus.cquwl.Algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cactus.cquwl.pojo.BasicGood;
import com.cactus.cquwl.pojo.CarSource;

/*
 * 算法一：
 * 箱子竖着摆放，最多可以摆多少个
 * 思想如下：
 * 箱子length为l，width为w,height为h； 车子length为lc,width为wc,heigth为hc;
 * length方向可以放置nl=lc/w 个箱子；
 * width 方向可以放置nw=wc/l 个箱子
 * 一层可以放置 nl*nw 个箱子
 * 另外，考虑width方向 的箱子没有放满的空间可以放置转向的箱子的情况
 * 如果 wc-nl*l > w && lc > l, 则可以放置箱子, 可以放置  ( (wc-nl*l)/w ) * ( lc/l )个箱子;
 * 因此一层总的可以放置 nl * nw +  ( (wc-nl*l)/w ) * ( lc/l ) 个箱子
 * 按照车子的高度和箱子的高度， 
 * 如果 hc < h 放置不下
 * 否则： 可以放置 hc / h 层
 * 
 */
public class ConcreteStrategyWidthCount extends Strategy{

	private static final String stragemsg2 = "摆放方案二";
	private static final String stragemsg4 = "摆放方案四";
	private static final String stragepic2 = "assets/img/stragepic/201612141112382.png";
	private static final String stragepic4 = "assets/img/stragepic/201612141112384.png";
	
	@Override
	public String algorithm(BasicGood bg, CarSource cs, BasicGood hbg, int count) {
		// TODO Auto-generated method stub
		float l = bg.getUnitLength();
		float w = bg.getUnitWidth();
		float h = bg.getUnitHeight();
		
		int allCount = 0;
		
		String strage = null; // 具体方案
		
		float lc =  0f;
		float wc = 0f;
		float hc = 0f;
		if(hbg == null){
			lc = cs.getCarLength();
			wc = cs.getCarWidth();
			hc = cs.getCarHeigth();
		}else{
			lc = cs.getCarLength() - hbg.getUnitWidth() * count;
			wc = cs.getCarWidth() - hbg.getUnitLength() * count;
			hc = cs.getCarHeigth() - hbg.getUnitHeight() * count;
		}
		
		int nl = (int) (lc/w);
		int nw = (int) (wc/l);
		
		int addition = 0; 
		
		if((wc - nw * l) >= w && (lc >= l))
			addition =  (int)((wc - nw * l ) / w) * (int)( lc / l );
		
		if(hc < h)
			return allCount + "&" + "" + "&" + "";
		else{
			allCount = ( nl * nw + addition ) * (int)(hc / h);
			
			if(addition == 0) {
				strage = stragemsg2 + "&" +"(" + nl + "x" + nw  +")x" + (int)(hc / h) + "&" + stragepic2;
			}else {
				strage = stragemsg4 + "&" + "(" + nl + "x" + nw + "+" + addition +")x" + (int)(hc / h) + "&" + stragepic4;
			}
			return allCount + "&" + strage;
		}
	}
}
