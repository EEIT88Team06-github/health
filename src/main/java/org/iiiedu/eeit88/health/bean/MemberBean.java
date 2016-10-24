package org.iiiedu.eeit88.health.bean;

import java.sql.Date;

/**
 * 會員Bean
 * @author Nick
 *
 */
public class MemberBean {
//	mbmeer
	private int id; 
	
	private String lastname;
	
	private String firstname;
	
	private String gender;
	
	private String nickneme;
	

	private Date   birth;
	
	private String addr;
	
	private int bonus;
	
	private String phone;
	
	private float height;
	
	private float weights;
	
	private String email;
	
	private String city ;
	
	private String county;
	
	private boolean pair;
	
	
	private String account;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeights() {
		return weights;
	}

	public void setWeights(float weights) {
		this.weights = weights;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public boolean isPair() {
		return pair;
	}

	public void setPair(boolean pair) {
		this.pair = pair;
	}
	public String getNickneme() {
		return nickneme;
	}

	public void setNickneme(String nickneme) {
		this.nickneme = nickneme;
	}

	private String passwords;
	
	private String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
}
