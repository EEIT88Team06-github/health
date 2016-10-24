package org.iiiedu.eeit88.health.food.model;

import java.io.Serializable;

//本類別封裝了一筆攝取記錄的資料，並不會直接存取到資料庫
public class AbsorbShowBean implements Serializable {
	private String foodName;
	private java.util.Date absorbDate;
	private Integer quantity;
	private Float calories;
	private Float total;
	private Integer foodId;
	
	public AbsorbShowBean(){
		
	}
	
	public AbsorbShowBean(String foodName,java.util.Date absorbDate,Integer quantity,Float calories,Float total,Integer foodId){
		this.foodName = foodName;
		this.absorbDate = absorbDate;
		this.quantity = quantity;
		this.calories = calories;
		this.total = total;
		this.foodId = foodId;
	}

	@Override
	public String toString() {
		return "AbsorbShowBean [foodName=" + foodName + ", absorbDate=" + absorbDate + ", quantity=" + quantity
				+ ", calories=" + calories + ", total=" + total + ", foodId=" + foodId + "]";
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public java.util.Date getAbsorbDate() {
		return absorbDate;
	}

	public void setAbsorbDate(java.util.Date absorbDate) {
		this.absorbDate = absorbDate;
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

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	
	
	
}
