package com.cactus.cquwl.domain.entity;

public class CarAssessTable {

	/*
	 *  addStar("ddsj",1);
		   addStar("hshc",2);
			  addStar("fwtd",3);
			  addStar("sfhl",4);
	 */
	
	private int ddsj;
	private int hshc;
	private int fwtd;
	private int sfhl;
	
	public CarAssessTable(){
		this.ddsj = 5;
		this.hshc = 5;
		this.fwtd = 5;
		this.sfhl = 5;
	}
	
	/**
	 * @return the ddsj
	 */
	public int getDdsj() {
		return ddsj;
	}
	/**
	 * @param ddsj the ddsj to set
	 */
	public void setDdsj(int ddsj) {
		this.ddsj = ddsj;
	}
	/**
	 * @return the hshc
	 */
	public int getHshc() {
		return hshc;
	}
	/**
	 * @param hshc the hshc to set
	 */
	public void setHshc(int hshc) {
		this.hshc = hshc;
	}
	/**
	 * @return the fwtd
	 */
	public int getFwtd() {
		return fwtd;
	}
	/**
	 * @param fwtd the fwtd to set
	 */
	public void setFwtd(int fwtd) {
		this.fwtd = fwtd;
	}
	/**
	 * @return the sfhl
	 */
	public int getSfhl() {
		return sfhl;
	}
	/**
	 * @param sfhl the sfhl to set
	 */
	public void setSfhl(int sfhl) {
		this.sfhl = sfhl;
	}
	
}
