package org.iiiedu.eeit88.health.match.bean;

import java.util.Arrays;
import java.util.Date;

public class MatchBean {
	
	
	private static final long serialVersionUID = 1L;
	byte[]image;
	int id;
	String gender;
	String nickname;
	java.util.Date birth;
	String city;
	String country;
	int age;
	boolean pair;
	String[] ssex;
	String account;
	String passwords;
	
	
	public MatchBean() {
	}
	public MatchBean(int age) {
	}
	public MatchBean(String birth) {
	}
	public MatchBean(String[]ssex,String city,String country) {
		
		this.ssex=ssex;
		this.city=city;
		this.country=country;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "MatchBean [image=" + Arrays.toString(image) + ", id=" + id + ", gender=" + gender + ", nickname="
				+ nickname + ", birth=" + birth + ", city=" + city + ", country=" + country + ", age=" + age + ", pair="
				+ pair + ", ssex=" + Arrays.toString(ssex) + ", account=" + account + ", passwords=" + passwords + "]";
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public java.util.Date getBirth() {
		return birth;
	}
	public void setBirth(java.util.Date birth) {
		this.birth = birth;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isPair() {
		return pair;
	}
	public void setPair(boolean pair) {
		this.pair = pair;
	}
	
	public String[] getSsex() {
		return ssex;
	}
	public void setSsex(String[] ssex) {
		this.ssex = ssex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
