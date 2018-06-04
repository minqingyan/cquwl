package com.cactus.cquwl.domain.entity;

public class CarEasyMsg {
	
	private int id;
	private String img;
	private String name;
	private String msg;  //　如果是车辆就是车牌，　如果是仓库就是仓库名称
	private String phone;
	private String strage;  // 摆放方案
	private int sum;   // 总箱数
	private String sumDetail;  // 总箱详情  m x n + p
	private String strageImg;
	
	
	public String getStrageImg() {
		return strageImg;
	}
	public void setStrageImg(String strageImg) {
		this.strageImg = strageImg;
	}
	public String getStrage() {
		return strage;
	}
	public void setStrage(String strage) {
		this.strage = strage;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getSumDetail() {
		return sumDetail;
	}
	public void setSumDetail(String sumDetail) {
		this.sumDetail = sumDetail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	
	
}
