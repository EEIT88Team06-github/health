package org.iiiedu.eeit88.health.sport.model;

import java.io.Serializable;

public class SportRecommandBean implements Serializable {
	private Integer id;
	private java.util.Date sportRecommandDate;
	private Integer sportId;
	private Integer memId;
	
	@Override
	public String toString() {
		return "SportRecommandBean [id=" + id + ", sportRecommandDate=" + sportRecommandDate + ", sportId=" + sportId
				+ ", memId=" + memId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getSportRecommandDate() {
		return sportRecommandDate;
	}

	public void setSportRecommandDate(java.util.Date sportRecommandDate) {
		this.sportRecommandDate = sportRecommandDate;
	}

	public Integer getSportId() {
		return sportId;
	}

	public void setSportId(Integer sportId) {
		this.sportId = sportId;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	
	
}
