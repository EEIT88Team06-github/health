package org.iiiedu.eeit88.health.food.model;

public class DateBean {
	private Integer id;
	private java.util.Date date;
	
	
	@Override
	public String toString() {
		return "DateBean [id=" + id + ", date=" + date + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public java.util.Date getDate() {
		return date;
	}


	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	
	
}
