package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.MembersOnly.model.dao.detailDAODS;

public class detailService {
	private detailDAO Dao = new detailDAODS();
	
	
	public List<detailBean> select(detailBean bean){
		List<detailBean> result = null;
		if(bean!=null && bean.getId()!=0) {
			detailBean temp = Dao.select(bean.getId());
			if(temp!=null) {
				result = new ArrayList<detailBean>();
				result.add(temp);
			}
			
		} else {
			result = Dao.select(); 
		}
		return result;
	}
	
	public boolean delete(detailBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = Dao.delete(bean.getId());
		}
		return result;
	}
	
}

