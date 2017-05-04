package com.elink.hospitalhealthnurse.common.vo;

import java.io.Serializable;

/****
 * 监测正常范围
 * @author elink
 *
 */
public class NormalRange implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public double getNormalBeg() {
		return normalBeg;
	}

	public void setNormalBeg(double normalBeg) {
		this.normalBeg = normalBeg;
	}

	public double getNormalEnd() {
		return normalEnd;
	}

	public void setNormalEnd(double normalEnd) {
		this.normalEnd = normalEnd;
	}
	
	public NormalRange(){
		
	}
	
	public NormalRange(double normalBeg,double normalEnd){
		this.normalBeg = normalBeg;
		this.normalEnd = normalEnd;
	}

	private double normalBeg;
	
	private double normalEnd;

}
