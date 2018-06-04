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
@Table(name="cqu_myorders")
public class MyOrders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer id;   // 自增主键
	
	@Column(name = "order_id")
	private String orderId;  //订单编号
	@Column(name = "state")
	private Integer state;
	@Column(name = "flag")
	private Integer flag;     // 1货源（仓库）；2货源（车辆）；3车源；4仓库源
	@Column(name = "flagId")
	private Integer flagId;   
	@Column(name = "orderTime")
	private Date orderTime;   
	@ManyToOne(cascade = {CascadeType.MERGE })
	@JoinColumn(name = "myorders_adminUser_id")
	private AdminUser adminUser;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the flag
	 */
	public Integer getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * @return the flagId
	 */
	public Integer getFlagId() {
		return flagId;
	}
	/**
	 * @param flagId the flagId to set
	 */
	public void setFlagId(Integer flagId) {
		this.flagId = flagId;
	}
	/**
	 * @return the orderTime
	 */
	public Date getOrderTime() {
		return orderTime;
	}
	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
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
