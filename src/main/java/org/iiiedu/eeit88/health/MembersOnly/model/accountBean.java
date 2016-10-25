package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class accountBean {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
		applySettings(configuration.getProperties()).build();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		org.hibernate.Transaction trx = session.beginTransaction();
		
		
			//
//		accountBean in = new accountBean();
//		in.setId(50);
//		in.setAccount("hthgf486");
//		session.save(in);
		
		accountBean se = (accountBean) session.get(accountBean.class, 19);
		System.out.println(se);
		
		trx.commit();
		session.close();
		factory.close();
	}
	
	private Integer id;
	private String lastname;
	private String firstname;
	private String gender;
	private String nickname;
	private java.util.Date birth;
	private String phone;
	private String account;
	private String email;
	private String city;
	private String conunty;
	private String addr;

	private Integer bonus;
	private String pair;
	private Float height;
	private Float weights;
	
	
	private byte[] passwords;
	private byte[] picture;

	public byte[] getPasswords() {
		return passwords;
	}

	public void setPasswords(byte[] passwords) {
		this.passwords = passwords;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public Float getWeights() {
		return weights;
	}
	public void setWeights(Float weights) {
		this.weights = weights;
	}
	public Integer getBonus() {
		return bonus;
	}
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "accountBean [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", gender=" + gender
				+ ", nickname=" + nickname + ", birth=" + birth + ", phone=" + phone + ", account=" + account
				+ ", email=" + email + ", city=" + city + ", conunty=" + conunty + ", addr=" + addr + ", bonus=" + bonus
				+ ", pair=" + pair + ", height=" + height + ", weights=" + weights + ", passwords="
				+ Arrays.toString(passwords) + ", picture=" + Arrays.toString(picture) + "]";
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public String getConunty() {
		return conunty;
	}
	public void setConunty(String conunty) {
		this.conunty = conunty;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
}

