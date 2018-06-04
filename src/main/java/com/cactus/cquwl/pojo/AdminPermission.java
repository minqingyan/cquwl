package com.cactus.cquwl.pojo;

public class AdminPermission {
	
	 private Integer permissionId; 
     private String permissionURL;
     private String permissionDescription;
     private AdminRole role;
     
	/**
	 * @return the permissionId
	 */
	public Integer getPermissionId() {
		return permissionId;
	}
	/**
	 * @param permissionId the permissionId to set
	 */
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	/**
	 * @return the permissionURL
	 */
	public String getPermissionURL() {
		return permissionURL;
	}
	/**
	 * @param permissionURL the permissionURL to set
	 */
	public void setPermissionURL(String permissionURL) {
		this.permissionURL = permissionURL;
	}
	/**
	 * @return the permissionDescription
	 */
	public String getPermissionDescription() {
		return permissionDescription;
	}
	/**
	 * @param permissionDescription the permissionDescription to set
	 */
	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}
	/**
	 * @return the role
	 */
	public AdminRole getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(AdminRole role) {
		this.role = role;
	}
     
}
