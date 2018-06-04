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
@Table(name="cqu_adminuserrole")
public class AdminUserRole {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	 private Integer id; 
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "adminuserrole_user_id")
     private AdminUser user;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "adminuserrole_role_id")
	private AdminRole role;
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
	 * @return the user
	 */
	public AdminUser getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(AdminUser user) {
		this.user = user;
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
