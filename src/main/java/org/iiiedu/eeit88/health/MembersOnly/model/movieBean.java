package org.iiiedu.eeit88.health.MembersOnly.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class movieBean {
	private Integer id;
	private String type;
	private Integer memid;
	private String moviesubject;
	private String content;
	private java.util.Date upload;
	private boolean moviestatus;
	
	
	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = 
				new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = 
				new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		
		
		movieBean in = new movieBean();
		in.setId(5);
		in.setContent("ggg");
		in.setMemid(5);
		session.save(in);
//		
//		movieBean se = (movieBean) session.get(movieBean.class, 2);
//		System.out.println(se);
		
		
		trx.commit();
		session.close();
		factory.close();
	}



	@Override
	public String toString() {
		return "movieBean [id=" + id + ", type=" + type + ", memid=" + memid + ", moviesubject=" + moviesubject
				+ ", content=" + content + ", upload=" + upload + ", moviestatus=" + moviestatus + "]";
	}
	
	public Integer getMemid() {
		return memid;
	}
	public void setMemid(Integer memid) {
		this.memid = memid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isMoviestatus() {
		return moviestatus;
	}
	public void setMoviestatus(boolean moviestatus) {
		this.moviestatus = moviestatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getMoviesubject() {
		return moviesubject;
	}
	public void setMoviesubject(String moviesubject) {
		this.moviesubject = moviesubject;
	}
	public java.util.Date getUpload() {
		return upload;
	}
	public void setUpload(java.util.Date upload) {
		this.upload = upload;
	}

}
