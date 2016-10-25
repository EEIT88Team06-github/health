package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.MembersOnly.model.dao.slimminglogDAODS;
import org.iiiedu.eeit88.health.MembersOnly.model.dao.subjectDAODS;

public class subjectService {
private subjectDAO Dao = new subjectDAODS();
	
	public List<subjectBean> select(int memid) {
		List<subjectBean> result = null;
		result = Dao.select(memid);
		return result;
	}
	
//	public List<subjectBean> select(subjectBean bean) {
//		List<subjectBean> result = null;
//		if(bean!=null && bean.getMemid()!=0) {
//			List<subjectBean> temp = Dao.select(bean.getMemid());
//			if(temp!=null) {
//				result = new ArrayList<subjectBean>();
//				result.add(temp);
//			}
//		} else {
//			result = Dao.select(); 
//		}
//		return result;
//	}
}
