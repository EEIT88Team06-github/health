package org.iiiedu.eeit88.health.food.model;

import java.io.Serializable;

//這個bean並不會存進資料庫，用來裝單筆熱量攝取紀錄
public class AbsorbItemsBean implements Serializable {
	private Integer foodId;
	private Integer quantity;
	private Float calories;
	private String foodName;

	
	
	public AbsorbItemsBean(){
		
	}
	public AbsorbItemsBean(int foodId,int quantity,float calories,String foodName){
		this.foodId = foodId;
		this.quantity = quantity;
		this.calories = calories;
		this.foodName = foodName;
	}
	
	@Override
	public String toString() {
		return "AbsorbItemBean [foodId=" + foodId + ", quantity=" + quantity + ", calories=" + calories + ", foodName="
				+ foodName + "]";
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
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

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	
	
}
