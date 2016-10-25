package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.MembersOnly.model.dao.logpicDAODS;
import org.iiiedu.eeit88.health.MembersOnly.model.dao.slimminglogDAODS;

public class logpicService {
	private logpicDAO Dao = new logpicDAODS();
	

	public logpicBean select(int id) {
		logpicBean result = Dao.select(id);
		return result;
	}

	public List<logpicBean> select(logpicBean bean) {
		List<logpicBean> result = null;
		if(bean!=null && bean.getId()!=0) {
			logpicBean temp = Dao.select(bean.getId());
			if(temp!=null) {
				result = new ArrayList<logpicBean>();
				result.add(temp);
			}
		} else {
			result = Dao.select(); 
		}
		return result;
	}
}
