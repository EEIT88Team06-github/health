package org.iiiedu.eeit88.health.namage.model;

public class PermissionsBean {
	
	private Integer id;
	private String lastname;
	private String firstname;
	private String nickname;
	private String account;
	private String gender;
	private Integer bonus;
	
	
	public Integer getBonus() {
		return bonus;
	}
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	public String getGender() {
		return gender;
	}
	@Override
	public String toString() {
		return "PermissionsBean [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", nickname="
				+ nickname + ", account=" + account + ", gender=" + gender + ", bonus=" + bonus + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setGender(String string) {
		// TODO Auto-generated method stub
		
	}

	
	
}
