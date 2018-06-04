package com.cactus.cquwl.Util;

public enum GoodUtil {  //件杂货
	
	typeA("酒类饮料",1),
	typeB("塑料和橡胶",2),
	typeC("皮革和纺织品",3),
	typeD("纸和纸制品",4),
	typeE("书和印刷品",5),
	typeF("编结品",6),
	typeG("文教用品",7),
	typeH("日用百货",8),
	typeI("非金属矿物产品",9),
	typeJ("其他",10);
	
	private String name;
	
	private int flag;
	
	private GoodUtil(String name,int flag){
		this.name=name;
		this.flag=flag;
	}

	
	public static String getName(int flag){
		for(GoodUtil car:GoodUtil.values()){
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
