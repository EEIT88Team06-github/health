package org.iiiedu.eeit88.health.shoppingcart.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class DiscountBean implements Serializable{

	private Integer id;
	private Timestamp startDate;
	private Timestamp endDate;
	private Float discount;
	private Integer prodType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Integer getProdType() {
		return prodType;
	}
	public void setProdType(Integer prodType) {
		this.prodType = prodType;
	}
	@Override
	public String toString() {
		return "DiscountBean [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", discount=" + discount
				+ ", prodType=" + prodType + "]";
	}
	
}
