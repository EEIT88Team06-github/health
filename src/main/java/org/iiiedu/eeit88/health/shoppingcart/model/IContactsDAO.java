package org.iiiedu.eeit88.health.shoppingcart.model;

import java.util.List;

public interface IContactsDAO {
	public abstract List<ContactsBean> select(int memId);
	public abstract ContactsBean selectOne(int id);	
	public abstract Boolean insert(ContactsBean bean);
	public abstract Boolean update(ContactsBean bean);
	public abstract Boolean delete(int id);
}
