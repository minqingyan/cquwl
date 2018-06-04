package com.cactus.cquwl.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cqu_adminrole")
public class AdminRole {
	/*
	 一个用户可以有多种角色（normal,manager,admin等等）
	一个角色可以有多个用户（user1,user2,user3等等）
	一个角色可以有多个权限（save,update,delete,query等等）
	一个权限只属于一个角色（delete只属于manager角色） 
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer roleId; 
	@Column(name = "roleName")
     private String roleName;
	@Column(name = "roleDescription")
     private String roleDescription;
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}
	/**
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
}
