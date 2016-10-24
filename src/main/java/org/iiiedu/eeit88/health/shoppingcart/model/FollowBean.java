package org.iiiedu.eeit88.health.shoppingcart.model;

import java.io.Serializable;

public class FollowBean implements Serializable{

	private Integer id;
	private Integer prodId;
	private Integer memId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public Integer getMemId() {
		return memId;
	}
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	@Override
	public String toString() {
		return "FollowBean [id=" + id + ", prodId=" + prodId + ", memId=" + memId + "]";
	}
}
