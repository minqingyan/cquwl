package com.cactus.cquwl.pojo;

import java.util.List;

public class AdminRole_Permission_xref {

	 private Integer rolePermissionId;  
	 private List<AdminRole>  roleList;         
	 private List<AdminPermission>  permissionList;
	/**
	 * @return the rolePermissionId
	 */
	public Integer getRolePermissionId() {
		return rolePermissionId;
	}
	/**
	 * @param rolePermissionId the rolePermissionId to set
	 */
	public void setRolePermissionId(Integer rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
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
	 * @return the permissionList
	 */
	public List<AdminPermission> getPermissionList() {
		return permissionList;
	}
	/**
	 * @param permissionList the permissionList to set
	 */
	public void setPermissionList(List<AdminPermission> permissionList) {
		this.permissionList = permissionList;
	}
	 
	 
}
