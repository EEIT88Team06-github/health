package org.iiiedu.eeit88.health.sport.model;

import java.io.Serializable;

public class ConsumeDetailBean implements Serializable {
	private Integer id;
	private Integer consumeId;
	private Integer sportId;
	private Integer quantity;
	
	public ConsumeDetailBean(){
		
	}
	
	public ConsumeDetailBean(Integer id,Integer consumeId,Integer sportId,Integer quantity){
		this.id = id;
		this.consumeId = consumeId;
		this.sportId = sportId;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ConsumeDetailBean [id=" + id + ", consumeId=" + consumeId + ", sportId=" + sportId + ", quantity="
				+ quantity + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConsumeId() {
		return consumeId;
	}

	public void setConsumeId(Integer consumeId) {
		this.consumeId = consumeId;
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
	
	
	
	
}
