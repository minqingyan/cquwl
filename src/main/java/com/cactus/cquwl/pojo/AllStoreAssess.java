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
@Table(name="cqu_allstoreassess")
public class AllStoreAssess {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer storeAssId;
	@Column(name="environment")
	private Integer environment;
	@Column(name="quality")
	private Integer quality;
	@Column(name="attitude")
	private Integer attitude;
	@Column(name="pay")
	private Integer pay;
	@Column(name="state")
	private Integer state;
	@Column(name="words")
	private String words;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "basicStoreAssess_StoreSouce_id")
	private StoreSource store;
	/**
	 * @return the storeAssId
	 */
	public Integer getStoreAssId() {
		return storeAssId;
	}
	/**
	 * @param storeAssId the storeAssId to set
	 */
	public void setStoreAssId(Integer storeAssId) {
		this.storeAssId = storeAssId;
	}
	/**
	 * @return the environment
	 */
	public Integer getEnvironment() {
		return environment;
	}
	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(Integer environment) {
		this.environment = environment;
	}
	/**
	 * @return the quality
	 */
	public Integer getQuality() {
		return quality;
	}
	/**
	 * @param quality the quality to set
	 */
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	/**
	 * @return the attitude
	 */
	public Integer getAttitude() {
		return attitude;
	}
	/**
	 * @param attitude the attitude to set
	 */
	public void setAttitude(Integer attitude) {
		this.attitude = attitude;
	}
	/**
	 * @return the pay
	 */
	public Integer getPay() {
		return pay;
	}
	/**
	 * @param pay the pay to set
	 */
	public void setPay(Integer pay) {
		this.pay = pay;
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
	 * @return the words
	 */
	public String getWords() {
		return words;
	}
	/**
	 * @param words the words to set
	 */
	public void setWords(String words) {
		this.words = words;
	}
	/**
	 * @return the store
	 */
	public StoreSource getStore() {
		return store;
	}
	/**
	 * @param store the store to set
	 */
	public void setStore(StoreSource store) {
		this.store = store;
	}
	
	
}
