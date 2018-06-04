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

//所有车源评价统计
@Entity
@Table(name="cqu_allcarassess")
public class AllCarAssess {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer carAssId;
	@Column(name="arriveScore")
	private Integer arriveScore;
	@Column(name="goodSafe")
	private Integer goodSafe;
	@Column(name="serviceScore")
	private Integer serviceScore;
	@Column(name="payScore")
	private Integer payScore;
	@Column(name="score")
	private Integer score;
	@Column(name="state")
	private Integer state;
	@Column(name="words")
	private String words;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "allcarassess_carsource_id")
	private CarSource car;
	
	/**
	 * @return the car
	 */
	public CarSource getCar() {
		return car;
	}
	/**
	 * @param car the car to set
	 */
	public void setCar(CarSource car) {
		this.car = car;
	}
	/**
	 * @return the carAssId
	 */
	public Integer getCarAssId() {
		return carAssId;
	}
	/**
	 * @param carAssId the carAssId to set
	 */
	public void setCarAssId(Integer carAssId) {
		this.carAssId = carAssId;
	}
	/**
	 * @return the arriveScore
	 */
	public Integer getArriveScore() {
		return arriveScore;
	}
	/**
	 * @param arriveScore the arriveScore to set
	 */
	public void setArriveScore(Integer arriveScore) {
		this.arriveScore = arriveScore;
	}
	/**
	 * @return the goodSafe
	 */
	public Integer getGoodSafe() {
		return goodSafe;
	}
	/**
	 * @param goodSafe the goodSafe to set
	 */
	public void setGoodSafe(Integer goodSafe) {
		this.goodSafe = goodSafe;
	}
	/**
	 * @return the serviceScore
	 */
	public Integer getServiceScore() {
		return serviceScore;
	}
	/**
	 * @param serviceScore the serviceScore to set
	 */
	public void setServiceScore(Integer serviceScore) {
		this.serviceScore = serviceScore;
	}
	/**
	 * @return the payScore
	 */
	public Integer getPayScore() {
		return payScore;
	}
	/**
	 * @param payScore the payScore to set
	 */
	public void setPayScore(Integer payScore) {
		this.payScore = payScore;
	}
	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
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
	
	
}
