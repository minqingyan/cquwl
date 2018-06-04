package com.cactus.cquwl.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cqu_carsource")
public class CarSource {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer carId;
	@Column(name = "carNumber")
	private String carNumber;
	@Column(name = "type")
	private Integer type;  // 车型
	@Column(name = "carriage")
	private Integer carriage;
	@Column(name = "weight")
	private Float weight;
	@Column(name = "volumn")
	private Float volumn;
	@Column(name = "carCount")
	private Integer carCount;
	@Column(name = "carLength")
	private Float carLength;
	@Column(name = "carWidth")
	private Float carWidth;
	@Column(name = "carHeigth")
	private Float carHeigth;
	@Column(name = "carPool")
	private Integer carPool;
	@Column(name = "state")
	private Integer state;
	
	//出发地目的地
	@Column(name="placeStart")
	private String placeStart;
	@Column(name="placeArrive")
	private String placeArrive;
	@Column(name="startTime")
	private String startTime;
	@Column(name="arriveTime")
	private String arriveTime;
	
	@Column(name = "publishTime")
	private Date publishTime;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "carsource_publish_id")
	private MyPublish publish;

	
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
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the arriveTime
	 */
	public String getArriveTime() {
		return arriveTime;
	}
	/**
	 * @param arriveTime the arriveTime to set
	 */
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	/**
	 * @return the carId
	 */
	public Integer getCarId() {
		return carId;
	}
	/**
	 * @param carId the carId to set
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
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
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * @return the carriage
	 */
	public Integer getCarriage() {
		return carriage;
	}
	/**
	 * @param carriage the carriage to set
	 */
	public void setCarriage(Integer carriage) {
		this.carriage = carriage;
	}
	/**
	 * @return the weight
	 */
	public Float getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	/**
	 * @return the volumn
	 */
	public Float getVolumn() {
		return volumn;
	}
	/**
	 * @param volumn the volumn to set
	 */
	public void setVolumn(Float volumn) {
		this.volumn = volumn;
	}
	/**
	 * @return the carCount
	 */
	public Integer getCarCount() {
		return carCount;
	}
	/**
	 * @param carCount the carCount to set
	 */
	public void setCarCount(Integer carCount) {
		this.carCount = carCount;
	}
	/**
	 * @return the carLength
	 */
	public Float getCarLength() {
		return carLength;
	}
	/**
	 * @param carLength the carLength to set
	 */
	public void setCarLength(Float carLength) {
		this.carLength = carLength;
	}
	/**
	 * @return the carWidth
	 */
	public Float getCarWidth() {
		return carWidth;
	}
	/**
	 * @param carWidth the carWidth to set
	 */
	public void setCarWidth(Float carWidth) {
		this.carWidth = carWidth;
	}
	/**
	 * @return the carHeigth
	 */
	public Float getCarHeigth() {
		return carHeigth;
	}
	/**
	 * @param carHeigth the carHeigth to set
	 */
	public void setCarHeigth(Float carHeigth) {
		this.carHeigth = carHeigth;
	}
	/**
	 * @return the carPool
	 */
	public Integer getCarPool() {
		return carPool;
	}
	/**
	 * @param carPool the carPool to set
	 */
	public void setCarPool(String carPool) {
		this.carPool = carPool=="是"?1:2;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the publishTime
	 */
	public Date getPublishTime() {
		return publishTime;
	}
	/**
	 * @param publishTime the publishTime to set
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	/**
	 * @return the publish
	 */
	public MyPublish getPublish() {
		return publish;
	}
	/**
	 * @param publish the publish to set
	 */
	public void setPublish(MyPublish publish) {
		this.publish = publish;
	}
	
}
