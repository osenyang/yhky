package com.elink.hospitalhealthnurse.common.vo;

import java.io.Serializable;
/****
 * Y轴
 * @author 刘灵星
 *
 */
public class Series implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;

	private String[] categories;
	
	private NormalRange normalRange;

	private SeriesData[] data;
	
	public Series(){
		
	}
	
	public Series(String name,String[] categories,SeriesData[] data ,NormalRange normalRange){
		this.name = name;
		this.categories = categories;
		this.data = data;
		this.normalRange = normalRange;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}
	
	public NormalRange getNormalRange() {
		return normalRange;
	}

	public void setNormalRange(NormalRange normalRange) {
		this.normalRange = normalRange;
	}

	public SeriesData[] getData() {
		return data;
	}

	public void setData(SeriesData[] data) {
		this.data = data;
	}

}
