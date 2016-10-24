package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.Arrays;

public class logpicBean {

	private Integer logid;
	private byte[] pic;
	private Integer id;
	
	
	@Override
	public String toString() {
		return "logpicBean [logid=" + logid + ", pic=" + Arrays.toString(pic) + ", id=" + id + "]";
	}
	public Integer getLogid() {
		return logid;
	}
	public void setLogid(Integer logid) {
		this.logid = logid;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
