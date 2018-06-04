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
@Table(name="cqu_storegood")
public class StoreGood {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer goodId;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "weight")
	private Float weight;
	@Column(name = "volumn")
	private Float volumn;
	@Column(name = "cover")
	private Float cover;
	@Column(name = "storeArea")
	private String storeArea;
	@Column(name = "storeDate")
	private String storeDate;
	@Column(name = "state")
	private Integer state;
	@Column(name = "publishDate")
	private Date publishDate;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "storegood_mypublish_id")
	private MyPublish myPublish;
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Float getVolumn() {
		return volumn;
	}
	public void setVolumn(Float volumn) {
		this.volumn = volumn;
	}
	public Float getCover() {
		return cover;
	}
	public void setCover(Float cover) {
		this.cover = cover;
	}
	public String getStoreArea() {
		return storeArea;
	}
	public void setStoreArea(String storeArea) {
		this.storeArea = storeArea;
	}
	
	public String getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(String storeDate) {
		this.storeDate = storeDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public MyPublish getMyPublish() {
		return myPublish;
	}
	public void setMyPublish(MyPublish myPublish) {
		this.myPublish = myPublish;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
}
