package org.iiiedu.eeit88.health.shoppingcart.model;

import java.io.Serializable;

public class ContactsBean implements Serializable{

	private Integer id;
	private String contactAddress;
	private String phone;
	private String name;
	private Integer memId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMemId() {
		return memId;
	}
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	@Override
	public String toString() {
		return "ContactsBean [id=" + id + ", contactAddress=" + contactAddress + ", phone=" + phone + ", name=" + name
				+ ", memId=" + memId + "]";
	}
}
