package com.cactus.cquwl.pojo;

import java.io.Serializable;
import java.text.ParseException;
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

import com.cactus.cquwl.Util.TextUtil;
import com.cactus.cquwl.Util.TimeUtil;

@Entity
@Table(name="cqu_basicgood")
public class BasicGood implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer goodId;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private Integer type;
	@Column(name = "weight")
	private float weight;
	@Column(name = "volumn")
	private float volumn;
	@Column(name = "delivery_time")
	private String deliveryTime;
	@Column(name = "unload_time")
	private String unloadTime;
	@Column(name = "state")
	private Integer state;
	@Column(name = "publish_time")
	private Date publishTime;
	@Column(name = "total_pack")
	private Integer totalPack;
	@Column(name = "unit_length")
	private Float unitLength;
	@Column(name = "unit_width")
	private Float unitWidth;
	@Column(name = "user_height")
	private Float unitHeight;
	@Column(name = "user_weight")
	private Float unitWeight;
	@Column(name = "carpool")
	private Integer carpool;
	
	@Column(name = "placeStart")
	private String placeStart;
	@Column(name = "placeArrive")
	private String placeArrive;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "basicGood_publish_id")
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
	 * @return the 
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the goodId
	 */
	public Integer getGoodId() {
		return goodId;
	}
	/**
	 * @param goodId the goodId to set
	 */
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * @return the totalPack
	 */
	public Integer getTotalPack() {
		return totalPack;
	}
	/**
	 * @param totalPack the totalPack to set
	 */
	public void setTotalPack(Integer totalPack) {
		this.totalPack = totalPack;
	}
	/**
	 * @return the unitLength
	 */
	public Float getUnitLength() {
		return unitLength == null ? 0 : unitLength;
	}
	/**
	 * @param unitLength the unitLength to set
	 */
	public void setUnitLength(Float unitLength) {
		this.unitLength = unitLength == null ? 0 : unitLength;
	}
	/**
	 * @return the unitWidth
	 */
	public Float getUnitWidth() {
		return unitWidth == null ? 0 : unitWidth;
	}
	/**
	 * @param unitWidth the unitWidth to set
	 */
	public void setUnitWidth(Float unitWidth) {
		this.unitWidth = unitWidth == null ? 0 : unitWidth;
	}
	/**
	 * @return the unitHeight
	 */
	public Float getUnitHeight() {
		return unitHeight == null ? 0 : unitHeight ;
	}
	/**
	 * @param unitHeight the unitHeight to set
	 */
	public void setUnitHeight(Float unitHeight) {
		this.unitHeight = unitHeight == null ? 0 : unitHeight;
	}
	/**
	 * @return the unitWeight
	 */
	public Float getUnitWeight() {
		return unitWeight == null ? 0 :unitWeight;
	}
	/**
	 * @param unitWeight the unitWeight to set
	 */
	public void setUnitWeight(Float unitWeight) {
		this.unitWeight = unitWeight == null ? 0 : unitWeight;
	}
	/**
	 * @return the carpool
	 */
	public Integer getCarpool() {
		return carpool;
	}
	/**
	 * @param carpool the carpool to set
	 */
	public void setCarpool(String carpool) {
		this.carpool = carpool== "是" ? 1: 2;
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
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	/**
	 * @return the volumn
	 */
	public float getVolumn() {
		return volumn;
	}
	/**
	 * @param volumn the volumn to set
	 */
	public void setVolumn(float volumn) {
		this.volumn = volumn;
	}
	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getUnloadTime() {
		return unloadTime;
	}
	public void setUnloadTime(String unloadTime) {
		this.unloadTime = unloadTime;
	}
	public void setCarpool(Integer carpool) {
		this.carpool = carpool;
	}
}
