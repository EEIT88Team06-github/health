package org.iiiedu.eeit88.health.shoppingcart.model.service;

import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.shoppingcart.model.ContactsBean;
import org.iiiedu.eeit88.health.shoppingcart.model.IContactsDAO;
import org.iiiedu.eeit88.health.shoppingcart.model.dao.ContactsDAODS;

public class ContactsService {
	private IContactsDAO dao = new ContactsDAODS();
	
	public List<ContactsBean> add(){
		List<ContactsBean> beans = new ArrayList<ContactsBean>();
		
		return beans;
	}

	public ContactsBean update(){
		ContactsBean bean = new ContactsBean();
		
		return bean;
	}
	
	public ContactsBean delete(){
		ContactsBean bean = new ContactsBean();
		
		return bean;		
	}

	public List<ContactsBean> selectAll(Integer memId) {
		List<ContactsBean> beans = new ArrayList<ContactsBean>();
		beans = dao.select(memId);
		return beans;
	}
	
	public ContactsBean selectOne(Integer id){
		ContactsBean bean = new ContactsBean();
		bean = dao.selectOne(id);
		return bean;
	}
}
