package com.cactus.cquwl.pojo;

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
@Table(name="cqu_goodassess")
public class GoodAssess {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer goodAssId;
	@Column(name = "assess")
	private Integer assess;
	@Column(name = "easyConnect")
	private Integer easyConnect;
	@Column(name = "payTime")
	private Integer payTime;
	@Column(name = "state")
	private Integer state;
	@Column(name = "words")
	private String words;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "goodassess_adminuser_id")
	private AdminUser adminUser;
	public Integer getGoodAssId() {
		return goodAssId;
	}
	public void setGoodAssId(Integer goodAssId) {
		this.goodAssId = goodAssId;
	}
	public Integer getAssess() {
		return assess;
	}
	public void setAssess(Integer assess) {
		this.assess = assess;
	}
	public Integer getEasyConnect() {
		return easyConnect;
	}
	public void setEasyConnect(Integer easyConnect) {
		this.easyConnect = easyConnect;
	}
	public Integer getPayTime() {
		return payTime;
	}
	public void setPayTime(Integer payTime) {
		this.payTime = payTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public AdminUser getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}
	
}
