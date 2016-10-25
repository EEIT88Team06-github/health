package org.iiiedu.eeit88.health.MembersOnly.model;

import java.security.Timestamp;

public class signinBean {

	private Integer id;
	private java.sql.Timestamp signintime;
	private java.sql.Timestamp lastsignin;
	private Integer continuous;
	private Integer memid;
	private boolean sign;


	public boolean getSign() {
		return sign;
	}

	public void setSign(boolean sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "signinBean [id=" + id + ", signintime=" + signintime + ", lastsignin=" + lastsignin + ", continuous="
				+ continuous + ", memid=" + memid + ", sign=" + sign + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getContinuous() {
		return continuous;
	}

	public void setContinuous(Integer continuous) {
		this.continuous = continuous;
	}

	public Integer getMemid() {
		return memid;
	}

	public void setMemid(Integer memid) {
		this.memid = memid;
	}

	public java.sql.Timestamp getSignintime() {
		return signintime;
	}

	public void setSignintime(java.sql.Timestamp signintime) {
		this.signintime = signintime;
	}

	public java.sql.Timestamp getLastsignin() {
		return lastsignin;
	}

	public void setLastsignin(java.sql.Timestamp lastsignin) {
		this.lastsignin = lastsignin;
	}


}
