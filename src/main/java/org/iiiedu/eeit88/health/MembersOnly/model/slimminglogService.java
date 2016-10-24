package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.MembersOnly.model.dao.slimminglogDAODS;

public class slimminglogService {
	private slimminglogDAO Dao = new slimminglogDAODS();
	
	public slimminglogBean select(int id) {
		slimminglogBean result = Dao.select(id);
		return result;
	}

	public List<slimminglogBean> select(slimminglogBean bean) {
		List<slimminglogBean> result = null;
		if(bean!=null && bean.getId()!=0) {
			slimminglogBean temp = Dao.select(bean.getId());
			if(temp!=null) {
				result = new ArrayList<slimminglogBean>();
				result.add(temp);
			}
		} else {
			result = Dao.select(); 
		}
		return result;
	}

	public slimminglogBean insert(slimminglogBean bean) {
		slimminglogBean result = null;
		if(bean!=null) {
			result = Dao.insert(bean);
		}
		return result;
	}

	public slimminglogBean update(slimminglogBean bean) {
		slimminglogBean result = null;
		if(bean!=null) {
			result = Dao.update(bean.getId(), bean.getDate(),
					bean.getContent(), bean.getShare());
		}
		return result;
	}

	public boolean delete(slimminglogBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = Dao.delete(bean.getId());
		}
		return result;
	}
	
	
	
	
}
