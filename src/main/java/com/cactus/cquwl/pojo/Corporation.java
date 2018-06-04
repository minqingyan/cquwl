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
@Table(name="cqu_corporation")
public class Corporation{

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer corporationId;
	@Column(name = "coType")
	private Integer coType;
	@Column(name = "coName")
	private String coName;
	@Column(name = "FOB")
	private String  FOB;
	@Column(name = "FOBImage")
	private String  FOBImage;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "corporation_adminuer_id")
	private AdminUser adminUser;
	

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
	/**
	 * @return the corporationId
	 */
	public Integer getCorporationId() {
		return corporationId;
	}
	/**
	 * @param corporationId the corporationId to set
	 */
	public void setCorporationId(Integer corporationId) {
		this.corporationId = corporationId;
	}
	/**
	 * @return the coType
	 */
	public Integer getCoType() {
		return coType;
	}
	/**
	 * @param coType the coType to set
	 */
	public void setCoType(Integer coType) {
		this.coType = coType;
	}
	/**
	 * @return the coName
	 */
	public String getCoName() {
		return coName;
	}
	/**
	 * @param coName the coName to set
	 */
	public void setCoName(String coName) {
		this.coName = coName;
	}
	/**
	 * @return the fOB
	 */
	public String getFOB() {
		return FOB;
	}
	/**
	 * @param fOB the fOB to set
	 */
	public void setFOB(String fOB) {
		this.FOB = fOB;
	}
	/**
	 * @return the fOBImage
	 */
	public String getFOBImage() {
		return FOBImage;
	}
	/**
	 * @param fOBImage the fOBImage to set
	 */
	public void setFOBImage(String fOBImage) {
		this.FOBImage = fOBImage;
	}
	
}
