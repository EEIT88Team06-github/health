package org.iiiedu.eeit88.health.shoppingcart.model;

public class ProductTypeBean {
	Integer id;
	String prodType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	@Override
	public String toString() {
		return "ProductTypeBean [id=" + id + ", prodType=" + prodType + "]";
	}
	
}
