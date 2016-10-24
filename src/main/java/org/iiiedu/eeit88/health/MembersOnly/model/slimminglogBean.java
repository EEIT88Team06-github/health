package org.iiiedu.eeit88.health.MembersOnly.model;

public class slimminglogBean {

	private Integer id;
	private java.util.Date date;
	private String content;
	private Integer memid;
	private Boolean share;
	
	
	
	@Override
	public String toString() {
		return "slimminglogBean [id=" + id + ", date=" + date + ", content=" + content + ", memid=" + memid
				+ ", share=" + share + "]";
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getMemid() {
		return memid;
	}
	public void setMemid(Integer memid) {
		this.memid = memid;
	}
	public Boolean getShare() {
		return share;
	}
	public void setShare(Boolean share) {
		this.share = share;
	}
	
}
