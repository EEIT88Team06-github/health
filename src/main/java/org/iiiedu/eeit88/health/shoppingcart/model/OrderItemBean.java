package org.iiiedu.eeit88.health.shoppingcart.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class OrderItemBean implements Serializable{

	private Integer id;
	private Integer bonus;
	private Integer memId;
	private String phone;
	private String arrival;
	private String orderItemAddress;
	private Timestamp shipTime;
	private Timestamp ordTime;
	private String ordNum;
	private String name;
	private Integer shipStatus;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getShipStatus() {
		return shipStatus;
	}
	public void setShipStatus(Integer shipStatus) {
		this.shipStatus = shipStatus;
	}
	public String getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBonus() {
		return bonus;
	}
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	public Integer getMemId() {
		return memId;
	}
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getOrderItemAddress() {
		return orderItemAddress;
	}
	public void setOrderItemAddress(String orderItemAddress) {
		this.orderItemAddress = orderItemAddress;
	}
	public Timestamp getShipTime() {
		return shipTime;
	}
	public void setShipTime(Timestamp shipTime) {
		this.shipTime = shipTime;
	}
	public Timestamp getOrdTime() {
		return ordTime;
	}
	public void setOrdTime(Timestamp ordTime) {
		this.ordTime = ordTime;
	}
	@Override
	public String toString() {
		return "OrderItemBean [id=" + id + ", bonus=" + bonus + ", memId=" + memId + ", phone=" + phone + ", arrival="
				+ arrival + ", orderItemAddress=" + orderItemAddress + ", shipTime=" + shipTime + ", ordTime=" + ordTime
				+ ", ordNum=" + ordNum + ", name=" + name + ", shipStatus=" + shipStatus + "]";
	}
	
	
		
}
