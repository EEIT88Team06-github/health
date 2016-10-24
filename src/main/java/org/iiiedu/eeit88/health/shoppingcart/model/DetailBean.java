package org.iiiedu.eeit88.health.shoppingcart.model;

import java.io.Serializable;

public class DetailBean implements Serializable{

	private Integer id;
	private Integer quantity;
	private Integer total;
	private String ordNum;
	private Integer prodId;
	private String prodName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	@Override
	public String toString() {
		return "DetailBean [id=" + id + ", quantity=" + quantity + ", total=" + total + ", ordNum=" + ordNum
				+ ", prodId=" + prodId + ", prodName=" + prodName + "]";
	}
	
	
}
