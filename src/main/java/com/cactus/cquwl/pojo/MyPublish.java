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
@Table(name="cqu_MyPublish")
public class MyPublish {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer puId;
	@Column(name = "state")
	private Integer state;
	@Column(name = "flag")
	private Integer flag;  // 1货源（仓库）；2货源（车辆）；3车源；4仓库源
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.MERGE })
	@JoinColumn(name = "MyPublish_adminUser_id")
	private AdminUser adminUser;
	
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * @return the puId
	 */
	public Integer getPuId() {
		return puId;
	}
	/**
	 * @param puId the puId to set
	 */
	public void setPuId(Integer puId) {
		this.puId = puId;
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
	 * @return the adminUser
	 */
	public AdminUser getAdminUser() {
		return adminUser;
	}
	/**
	 * @param adminUser the adminUser to set
	 */
	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}
	
}
