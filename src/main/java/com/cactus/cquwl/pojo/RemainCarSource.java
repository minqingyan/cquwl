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
@Table(name="cqu_RemainCarSource")
public class RemainCarSource {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer Id;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "remaincarsource_carsource_id")
	private CarSource carSource;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "remaincarsource_basicgood_id")
	private BasicGood basicGood;
	@Column(name = "count")
	private Integer count;
	@Column(name = "state")
	private Integer state;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}
	/**
	 * @return the carSource
	 */
	public CarSource getCarSource() {
		return carSource;
	}
	/**
	 * @param carSource the carSource to set
	 */
	public void setCarSource(CarSource carSource) {
		this.carSource = carSource;
	}
	/**
	 * @return the basicGood
	 */
	public BasicGood getBasicGood() {
		return basicGood;
	}
	/**
	 * @param basicGood the basicGood to set
	 */
	public void setBasicGood(BasicGood basicGood) {
		this.basicGood = basicGood;
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
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
}
