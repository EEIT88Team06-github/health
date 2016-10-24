package org.iiiedu.eeit88.health.food.model;

import java.io.Serializable;

public class CookRecommandBean implements Serializable {
	private Integer id;
	private java.util.Date cookRecommandDate;
	private Integer cookId;
	private Integer memId;
	
	@Override
	public String toString() {
		return "CookRecommandBean [id=" + id + ", cookRecommandDate=" + cookRecommandDate + ", cookId=" + cookId
				+ ", memId=" + memId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getCookRecommandDate() {
		return cookRecommandDate;
	}

	public void setCookRecommandDate(java.util.Date cookRecommandDate) {
		this.cookRecommandDate = cookRecommandDate;
	}

	public Integer getCookId() {
		return cookId;
	}

	public void setCookId(Integer cookId) {
		this.cookId = cookId;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	
	

}
