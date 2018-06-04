package com.cactus.cquwl.Util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TextUtil {

	public static boolean isNullObject(Object obj){
		if(obj==null)
			return true;
		else
			return false;
	}
	
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str)||"null".equals(str)){
			return true;
		}else
			return false;
	}
	
	public static float stringToFloat(String strFloat){
		if(isEmpty(strFloat)){
			return 0;
		}
		return Float.valueOf(strFloat.trim()).floatValue();
	}
	
	public static String caculate(float length,float width,float height){
		if(TextUtil.isNullObject(length) || TextUtil.isNullObject(width) || TextUtil.isNullObject(height))
			return "";
		else{
			float unitVolumn=length*width*height;
			StringBuffer sb=new StringBuffer();
			sb.append(processNumber(unitVolumn));
			sb.append("m^3/箱");
			return sb.toString();
		}
	}
	
	public static String processNumber(float d){
		DecimalFormat df = new DecimalFormat("0.0");
		return  df.format(d).toString();
	}
	
	public static String printOrderId(int flag) throws ParseException{
		// flag = 0 仓库货源   ；     flag=1 车辆 货源     ； flag=2 车源   ；flag=3  仓库源
		StringBuffer sb=new StringBuffer();
		if(flag == 1){
			sb.append("SH");
		}else if(flag == 2){
			sb.append("C");
		}else if(flag == 3){
			sb.append("S");
		}else if(flag == 0){
			sb.append("CH");
		}
		Date now=new Date();
		sb.append(now.getYear());
		sb.append(now.getMonth());
		sb.append(now.getDay());
		sb.append(now.getMinutes());
		sb.append(now.getSeconds());
		return sb.toString();
	}
	
	//是否评价
	public static String assess(int flag){
		// flag=2 未评价 flag=3 已经评价
		if(flag == 2 || flag == 1)
			return "未评价";
		else if(flag==3)
			return "已评价";
		return "";
	}
	
	
	public static int getRandom(){
		Random random = new Random();
		return random.nextInt(6);
	}
	
	public static int getFiveNumberRandom(){
		Random random = new Random();
		int max = 99999;
		int min = 10000;
		return random.nextInt(max)%(max-min+1) + min;
	}
}
