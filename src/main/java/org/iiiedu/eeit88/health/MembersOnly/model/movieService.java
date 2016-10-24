package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.MembersOnly.model.dao.movieDAODS;
import org.iiiedu.eeit88.health.MembersOnly.model.dao.slimminglogDAODS;

public class movieService {
	private movieDAO Dao = new movieDAODS();
	
	public List<movieBean> select(int memid) {
		List<movieBean> result = null;
		result = Dao.select(memid);
		return result;
	}

//	public List<movieBean> select(movieBean bean) {
//		List<movieBean> result = null;
//		if(bean!=null && bean.getMemid()!=0) {
//			movieBean temp = Dao.select(bean.getMemid());
//			if(temp!=null) {
//				result = new ArrayList<movieBean>();
//				result.add(temp);
//			}
//		} else {
//			result = Dao.select(); 
//		}
//		return result;
//	}
}
