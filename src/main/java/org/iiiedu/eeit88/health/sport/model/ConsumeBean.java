package org.iiiedu.eeit88.health.sport.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class ConsumeBean implements Serializable {
	private Integer id;
	private java.util.Date consumeDate;
	private Integer memId;
	private List<ConsumeDetailBean> items = new ArrayList<ConsumeDetailBean>();
	
	public ConsumeBean(){
		
	}
	
	public ConsumeBean(java.util.Date consumeDate,Integer memId,List<ConsumeDetailBean> items){
		this.consumeDate = consumeDate;
		this.memId = memId;
		this.items = items;
	}
	
	
	
	
	@Override
	public String toString() {
		return "ConsumeBean [id=" + id + ", consumeDate=" + consumeDate + ", memId=" + memId + ", items=" + items + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getConsumeDate() {
		return consumeDate;
	}

	public void setConsumeDate(java.util.Date consumeDate) {
		this.consumeDate = consumeDate;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public List<ConsumeDetailBean> getItems() {
		return items;
	}

	public void setItems(List<ConsumeDetailBean> items) {
		this.items = items;
	}
	
	
	
}
