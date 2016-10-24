package org.iiiedu.eeit88.health.MembersOnly.model;

public class collsubBean {

	private Integer id;
	private Integer subid;//文章編號
	private Integer memid;
	
	private java.util.Date publishtime;//	發布時間
	private String subjects;	 		//	主旨
	private Integer recommand;			//	讚
	private Integer replynum;			//	回文數量
	private Integer subjectstatus;		//顯示狀態
	private Integer popularity;			//	人氣
	

//	subject.publishtime,
//	subject.subjects,

	
	@Override
	public String toString() {
		return "collsub [id=" + id + ", subid=" + subid + ", memid=" + memid + ", publishtime=" + publishtime
				+ ", subjects=" + subjects + ", recommand=" + recommand + ", replynum=" + replynum + ", subjectstatus="
				+ subjectstatus + ", popularity=" + popularity + "]";
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSubid() {
		return subid;
	}
	public void setSubid(Integer subid) {
		this.subid = subid;
	}
	public Integer getMemid() {
		return memid;
	}
	public void setMemid(Integer memid) {
		this.memid = memid;
	}
	public java.util.Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(java.util.Date publishtime) {
		this.publishtime = publishtime;
	}
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	public Integer getRecommand() {
		return recommand;
	}
	public void setRecommand(Integer recommand) {
		this.recommand = recommand;
	}
	public Integer getReplynum() {
		return replynum;
	}
	public void setReplynum(Integer replynum) {
		this.replynum = replynum;
	}
	public Integer getSubjectstatus() {
		return subjectstatus;
	}
	public void setSubjectstatus(Integer subjectstatus) {
		this.subjectstatus = subjectstatus;
	}
	public Integer getPopularity() {
		return popularity;
	}
	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

}
