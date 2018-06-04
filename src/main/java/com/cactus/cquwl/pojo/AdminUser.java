package com.cactus.cquwl.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cqu_adminuser")
public class AdminUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminUserId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	 @Column(name = "phone")
	private String phone;
	 @Column(name = "email")
	private String email;
	 @Column(name = "area")
	private String area;
	 @Column(name = "area_detail")
	private String areaDetail;
	/** 是否删除 **/  
	 @Column(name = "idDelete")
    private Integer isDelete;     // 1 正常    0删除
    /** 创建时间 **/  
	 @Column(name = "createDate")
    private Date createDate;  
	

	 /*
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the areaDetail
	 */
	public String getAreaDetail() {
		return areaDetail;
	}
	/**
	 * @param areaDetail the areaDetail to set
	 */
	public void setAreaDetail(String areaDetail) {
		this.areaDetail = areaDetail;
	}
	/**
	 * @return the adminUserId
	 */
	public Integer getAdminUserId() {
		return adminUserId;
	}
	/**
	 * @param adminUserId the adminUserId to set
	 */
	public void setAdminUserId(Integer adminUserId) {
		this.adminUserId = adminUserId;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the isDelete
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
