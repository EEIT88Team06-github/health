package org.iiiedu.eeit88.health.sport.model;

import java.io.Serializable;
//這個bean並不會存進資料庫，用來裝單筆熱量消耗紀錄
public class ConsumeItemsBean implements Serializable {
	private Integer sportId;
	private Integer quantity;
	private Float calories;
	private String sportName;
	
	public ConsumeItemsBean(){
		
	}
	
	public ConsumeItemsBean(int sportId,int quantity,float calories,String sportName){
		this.sportId = sportId;
		this.quantity = quantity;
		this.calories = calories;
		this.sportName = sportName;
	}

	@Override
	public String toString() {
		return "ConsumeItemsBean [sportId=" + sportId + ", quantity=" + quantity + ", calories=" + calories
				+ ", sportName=" + sportName + "]";
	}

	public Integer getSportId() {
		return sportId;
	}

	public void setSportId(Integer sportId) {
		this.sportId = sportId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getCalories() {
		return calories;
	}

	public void setCalories(Float calories) {
		this.calories = calories;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	
	
}
