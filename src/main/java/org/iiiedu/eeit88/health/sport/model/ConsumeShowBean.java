package org.iiiedu.eeit88.health.sport.model;

import java.io.Serializable;

//本類別封裝了一筆消耗記錄的資料，並不會直接存取到資料庫
public class ConsumeShowBean implements Serializable {
	private String sportName;
	private java.util.Date consumeDate;
	private Integer quantity;
	private Float calories;
	private Float total;
	private Integer sportId;
	
	public ConsumeShowBean(){
		
	}
	
	public ConsumeShowBean(String sportName,java.util.Date consumeDate,Integer quantity,Float calories,Float total,Integer sportId ){
		this.sportName = sportName;
		this.sportId = sportId;
		this.consumeDate = consumeDate;
		this.quantity = quantity;
		this.calories = calories;
		this.total = total;
		this.sportId = sportId;
	}

	@Override
	public String toString() {
		return "ConsumeShowBean [sportName=" + sportName + ", consumeDate=" + consumeDate + ", quantity=" + quantity
				+ ", calories=" + calories + ", total=" + total + ", sportId=" + sportId + "]";
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public java.util.Date getConsumeDate() {
		return consumeDate;
	}

	public void setConsumeDate(java.util.Date consumeDate) {
		this.consumeDate = consumeDate;
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

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Integer getSportId() {
		return sportId;
	}

	public void setSportId(Integer sportId) {
		this.sportId = sportId;
	}
	
	
	
}
