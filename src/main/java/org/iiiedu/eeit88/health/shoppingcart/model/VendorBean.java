package org.iiiedu.eeit88.health.shoppingcart.model;

import java.io.Serializable;

public class VendorBean implements Serializable{

	private Integer id;
	private String name;
	private String bankAccount;
	private String mail;
	private String phone;
	private String vendorAddress;
	private String bankNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	@Override
	public String toString() {
		return "VendorBean [id=" + id + ", name=" + name + ", bankAccount=" + bankAccount + ", mail=" + mail
				+ ", phone=" + phone + ", vendorAddress=" + vendorAddress + ", bankNo=" + bankNo + "]";
	}
	
	
	
}
