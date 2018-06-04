package com.cactus.cquwl.Util;

public enum GoodUtilA {
	
	typeA("粮食谷物",1),
	typeB("棉花",2),
	typeC("煤炭",3),
	typeD("非金属矿石",4),
	typeE("矿物性建筑材料",5),
	typeF("水泥",6),
	typeG("盐制品",7),
	typeH("其他",8);
	private String name;
	
	private int flag;
	
	private GoodUtilA(String name,int flag){
		this.name=name;
		this.flag=flag;
	}

	
	public static String getName(int flag){
		for(GoodUtilA car:GoodUtilA.values()){
			if(car.getFlag()==flag){
				return car.getName()==null?"":car.getName();
			}
		}
		return "";
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}

}
