package com.cactus.cquwl.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cqu_totalgoodassess")
public class TotalGoodAssess {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer goodAssId;
	@Column(name="goodAssess")
	private Integer goodAssess;
	@Column(name="midAssess")
	private Integer midAssess;
	@Column(name="badAssess")
	private Integer badAssess;
	@Column(name="state")
	private Integer state;
	@OneToOne(cascade = {CascadeType.MERGE })
	@JoinColumn(name = "totalgoodassess_adminUser_id")
	private AdminUser adminUser;
	public Integer getGoodAssId() {
		return goodAssId;
	}
	public void setGoodAssId(Integer goodAssId) {
		this.goodAssId = goodAssId;
	}
	public Integer getGoodAssess() {
		return goodAssess;
	}
	public void setGoodAssess(Integer goodAssess) {
		this.goodAssess = goodAssess;
	}
	public Integer getMidAssess() {
		return midAssess;
	}
	public void setMidAssess(Integer midAssess) {
		this.midAssess = midAssess;
	}
	public Integer getBadAssess() {
		return badAssess;
	}
	public void setBadAssess(Integer badAssess) {
		this.badAssess = badAssess;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public AdminUser getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}
	
}
