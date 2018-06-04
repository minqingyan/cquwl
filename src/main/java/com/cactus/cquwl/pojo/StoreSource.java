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
@Table(name="cqu_StoreSource")
public class StoreSource {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer storeId;
	@Column(name = "name")
	private String name;
	@Column(name = "place")
	private String place;
	@Column(name = "startDate")
	private String startDate;
	@Column(name = "type")
	private String type;
	@Column(name = "area")
	private Float area;
	@Column(name = "volumn")
	private Float volumn;
	@Column(name = "state")
	private Integer state;
	@Column(name = "publishTime")
	private Date publishTime;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "StoreSource_publish_id")
	private MyPublish publish;
	
	public Float getVolumn() {
		return volumn;
	}
	public void setVolumn(Float volumn) {
		this.volumn = volumn;
	}
	/**
	 * @return the storeId
	 */
	public Integer getStoreId() {
		return storeId;
	}
	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
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
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the area
	 */
	public Float getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(Float area) {
		this.area = area;
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
