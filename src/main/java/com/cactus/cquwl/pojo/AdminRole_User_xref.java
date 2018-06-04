package com.cactus.cquwl.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class AdminRole_User_xref {

	private Integer roleUserId;
	private List<AdminRole> roleList;
	private List<AdminUser> adminUserList;
	/**
	 * @return the roleUserId
	 */
	public Integer getRoleUserId() {
		return roleUserId;
	}
	/**
	 * @param roleUserId the roleUserId to set
	 */
	public void setRoleUserId(Integer roleUserId) {
		this.roleUserId = roleUserId;
	}
	/**
	 * @return the roleList
	 */
	public List<AdminRole> getRoleList() {
		return roleList;
	}
	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(List<AdminRole> roleList) {
		this.roleList = roleList;
	}
	/**
	 * @return the adminUserList
	 */
	public List<AdminUser> getAdminUserList() {
		return adminUserList;
	}
	/**
	 * @param adminUserList the adminUserList to set
	 */
	public void setAdminUserList(List<AdminUser> adminUserList) {
		this.adminUserList = adminUserList;
	}
	
	
}
