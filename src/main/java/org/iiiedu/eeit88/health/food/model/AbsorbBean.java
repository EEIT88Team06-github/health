package org.iiiedu.eeit88.health.food.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AbsorbBean implements Serializable {
	
	private Integer id;
	private java.util.Date absorbDate;
	private Integer memId;
	private List<AbsorbDetailBean> items = new ArrayList<AbsorbDetailBean>();
	
	
	public AbsorbBean(){
		
	}
	
	public AbsorbBean(java.util.Date absorbDate,Integer memId,List<AbsorbDetailBean> items){
		this.absorbDate = absorbDate;
		this.memId = memId;
		this.items = items;
	}
	
	
	@Override
	public String toString() {
		return "AbsorbBean [id=" + id + ", absorbDate=" + absorbDate + ", memId=" + memId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getAbsorbDate() {
		return absorbDate;
	}

	public void setAbsorbDate(java.util.Date absorbDate) {
		this.absorbDate = absorbDate;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public List<AbsorbDetailBean> getItems() {
		return items;
	}

	public void setItems(List<AbsorbDetailBean> items) {
		this.items = items;
	}

	
	
	
	
	
}
