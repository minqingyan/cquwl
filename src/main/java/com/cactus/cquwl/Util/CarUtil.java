package com.cactus.cquwl.Util;

public enum CarUtil {

	typeA("栏板式",1),
	typeB("厢式",2),
	typeC("其他",3);
	
	private String name;
	
	private int flag;
	
	private CarUtil(String name,int flag){
		this.name=name;
		this.flag=flag;
	}

	
	public static String getName(int flag){
		for(CarUtil car:CarUtil.values()){
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
