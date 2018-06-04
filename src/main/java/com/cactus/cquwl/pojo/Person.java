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
@Table(name="cqu_Person")
public class Person{

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	 private Integer personId;
	@Column(name = "IDCard")
	 private String  IDCard;
	@Column(name = "IDCardFrontImage")
	 private String  IDCardFrontImage;
	@Column(name = "IDCardBackImage")
	 private String  IDCardBackImage;
	@Column(name = "IDCardHandImage")
	 private String  IDCardHandImage;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "Persion_adminUser_id")
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
	 * @return the persionId
	 */
	public Integer getPersionId() {
		return personId;
	}
	/**
	 * @param persionId the persionId to set
	 */
	public void setPersionId(Integer personId) {
		this.personId = personId;
	}
	/**
	 * @return the iDCard
	 */
	public String getIDCard() {
		return IDCard;
	}
	/**
	 * @param iDCard the iDCard to set
	 */
	public void setIDCard(String iDCard) {
		this.IDCard = iDCard;
	}
	/**
	 * @return the iDCardFrontImage
	 */
	public String getIDCardFrontImage() {
		return IDCardFrontImage;
	}
	/**
	 * @param iDCardFrontImage the iDCardFrontImage to set
	 */
	public void setIDCardFrontImage(String iDCardFrontImage) {
		this.IDCardFrontImage = iDCardFrontImage;
	}
	/**
	 * @return the iDCardBackImage
	 */
	public String getIDCardBackImage() {
		return IDCardBackImage;
	}
	/**
	 * @param iDCardBackImage the iDCardBackImage to set
	 */
	public void setIDCardBackImage(String iDCardBackImage) {
		this.IDCardBackImage = iDCardBackImage;
	}
	/**
	 * @return the iDCardHandImage
	 */
	public String getIDCardHandImage() {
		return IDCardHandImage;
	}
	/**
	 * @param iDCardHandImage the iDCardHandImage to set
	 */
	public void setIDCardHandImage(String iDCardHandImage) {
		this.IDCardHandImage = iDCardHandImage;
	}
	
	
}
