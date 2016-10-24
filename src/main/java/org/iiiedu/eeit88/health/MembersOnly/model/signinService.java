package org.iiiedu.eeit88.health.MembersOnly.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.MembersOnly.controller.signinServlt;
import org.iiiedu.eeit88.health.MembersOnly.model.dao.signinDAODS;

public class signinService {
	private signinDAO Dao = new signinDAODS();
	
	public List<signinBean> select(int memid) {
		List<signinBean> result = null;
		
		
		result = Dao.select(memid);
		return result;
	}
	
	public signinBean insert(signinBean bean) {
		signinBean result = null;
		if(bean!=null) {
			result = Dao.insert(bean);
		}
		return result;
	}
//	public signinBean select(int memid) {
//		signinBean result = Dao.select(memid);
//		return result;
//	}

	
	
//	public signinBean update(signinBean bean) {
//		signinBean result = null;
//		if(bean!=null) {
//			result = Dao.update(
//					bean.getId(), 
//					bean.getSignintime(),
//					bean.getLastsignin(), 
//					bean.getContinuous(),
//					bean.getMemid(),
//					bean.getSign());
//		}
//		return result;
//	}
	

	
//	public List<signinBean> select(signinBean bean) {
//	List<signinBean> result = null;
//	if(bean!=null && bean.getId()!=0) {
//		signinBean temp = Dao.select(bean.getId());
//		if(temp!=null) {
//			result = new ArrayList<signinBean>();
//			result.add(temp);
//		}
//	} else {
//		result = Dao.select(); 
//	}
//	return result;
//}
//
//public signinBean insert(signinBean bean) {
//	signinBean result = null;
//	if(bean!=null) {
//		result = Dao.insert(bean);
//	}
//	return result;
//}
//	public boolean delete(signinBean bean) {
//		boolean result = false;
//		if(bean!=null) {
//			result = Dao.delete(bean.getId());
//		}
//		return result;
//	}
//	
//	
//	
//	
	
//	public static void main(String[] args) {
//
//	int CS = 4;
//	signinService service = new signinService();
//	signinBean bean = new signinBean();
//	
//	
//	bean.setMemid(5);
//	bean.setSign(true);
//	Timestamp stamp = new Timestamp(System.currentTimeMillis());
//	bean.setLastsignin(stamp);
//	bean.setSignintime(stamp);
//	bean.setContinuous(CS);
//	service.insert(bean);
//	
//	
//	System.out.println(bean);
//	
//	}
	
}
