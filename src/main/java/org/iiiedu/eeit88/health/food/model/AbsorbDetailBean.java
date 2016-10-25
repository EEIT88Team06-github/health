package org.iiiedu.eeit88.health.food.model;

import java.io.Serializable;

public class AbsorbDetailBean implements Serializable{
	private Integer id;
	private Integer absorbId;
	private Integer foodId;
	private Integer quantity;
	
	public AbsorbDetailBean(){
		
	}
	
	public AbsorbDetailBean(Integer id, Integer absorbId,Integer foodId,Integer quantity){
		this.id = id;
		this.absorbId = absorbId;
		this.foodId = foodId;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "AbsorbDetailBean [id=" + id + ", absorbId=" + absorbId + ", foodId=" + foodId + ", quantity=" + quantity
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAbsorbId() {
		return absorbId;
	}

	public void setAbsorbId(Integer absorbId) {
		this.absorbId = absorbId;
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
	
	
	
}
