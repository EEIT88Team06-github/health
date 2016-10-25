package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.List;

import org.iiiedu.eeit88.health.MembersOnly.model.dao.collsubDAODS;

public class collsubService {
	private collsubDAO Dao = new collsubDAODS();
	
	public List<collsubBean> select(int memid) {
		List<collsubBean> result = null;
		result = Dao.select(memid);
		return result;
	}
	
	public boolean delete(collsubBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = Dao.delete(bean.getId());
		}
		return result;
	}
	
	
}
