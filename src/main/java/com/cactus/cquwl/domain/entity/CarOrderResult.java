package com.cactus.cquwl.domain.entity;

public class CarOrderResult {

	private int id;
	private String phone;
	private String orderId;  // 订单编号
	private String orderDate;
	private String carNumber;  // 车牌号
	private String placeStart; // 运输路线
	private String placeArrive;
	private String carOwnerName;
	private String registerDate;
	private String carType; // 车型
	private String maxWeight; //最大载重
	private String lwh;  // 长宽高
	private String isAssess; // 1 是未评价  2 是已评价
	private String img;
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the carNumber
	 */
	public String getCarNumber() {
		return carNumber;
	}
	/**
	 * @param carNumber the carNumber to set
	 */
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	/**
	 * @return the placeStart
	 */
	public String getPlaceStart() {
		return placeStart;
	}
	/**
	 * @param placeStart the placeStart to set
	 */
	public void setPlaceStart(String placeStart) {
		this.placeStart = placeStart;
	}
	/**
	 * @return the placeArrive
	 */
	public String getPlaceArrive() {
		return placeArrive;
	}
	/**
	 * @param placeArrive the placeArrive to set
	 */
	public void setPlaceArrive(String placeArrive) {
		this.placeArrive = placeArrive;
	}
	/**
	 * @return the carOwnerName
	 */
	public String getCarOwnerName() {
		return carOwnerName;
	}
	/**
	 * @param carOwnerName the carOwnerName to set
	 */
	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}
	/**
	 * @return the registerDate
	 */
	public String getRegisterDate() {
		return registerDate;
	}
	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * @return the carType
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * @param carType the carType to set
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	/**
	 * @return the maxWeight
	 */
	public String getMaxWeight() {
		return maxWeight;
	}
	/**
	 * @param maxWeight the maxWeight to set
	 */
	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
	}
	/**
	 * @return the lwh
	 */
	public String getLwh() {
		return lwh;
	}
	/**
	 * @param lwh the lwh to set
	 */
	public void setLwh(String lwh) {
		this.lwh = lwh;
	}
	/**
	 * @return the isAssess
	 */
	public String getIsAssess() {
		return isAssess;
	}
	/**
	 * @param isAssess the isAssess to set
	 */
	public void setIsAssess(String isAssess) {
		this.isAssess = isAssess;
	}  
	
}
