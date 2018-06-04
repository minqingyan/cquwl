package com.cactus.cquwl.domain.entity;

public class VehicleMsg {

	private String id;
	private String img;
	private String carOwnerName;
	private String registerDate;
	private String carNumber;
	private String carType; // 车型
	private String maxWeight; //最大载重
	private String lwh;  // 长宽高
	private String startPlace;
	private String destination;
	private String phone;
	
	
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the startPlace
	 */
	public String getStartPlace() {
		return startPlace;
	}
	/**
	 * @param startPlace the startPlace to set
	 */
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
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
	
	
}
