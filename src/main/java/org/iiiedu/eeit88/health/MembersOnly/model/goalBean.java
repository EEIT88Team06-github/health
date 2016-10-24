package org.iiiedu.eeit88.health.MembersOnly.model;

public class goalBean {
	private Integer goal;
	private Float content;
	private java.util.Date goaltime;
	private Integer memid;

	@Override
	public String toString() {
		return "goalBean [goal=" + goal + ", content=" + content + ", goaltime=" + goaltime + ", memid=" + memid + "]";
	}
	public Integer getGoal() {
		return goal;
	}
	public void setGoal(Integer goal) {
		this.goal = goal;
	}
	public Float getContent() {
		return content;
	}
	public void setContent(Float content) {
		this.content = content;
	}
	public java.util.Date getGoaltime() {
		return goaltime;
	}
	public void setGoaltime(java.util.Date goaltime) {
		this.goaltime = goaltime;
	}
	public Integer getMemid() {
		return memid;
	}
	public void setMemid(Integer memid) {
		this.memid = memid;
	}

}
