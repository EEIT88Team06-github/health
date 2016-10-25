package org.iiiedu.eeit88.health.namage.model;

import java.util.List;

import org.iiiedu.eeit88.health.namage.model.dao.PermissionsDAODS;

public class PermissionsService{
	
	private PermissionsDAO Dao = new PermissionsDAODS();
	
	public List<PermissionsBean> select() {
		List<PermissionsBean> result = null;
		result = Dao.select();
		return result;
	}
//	public List<PermissionsBean> select(PermissionsBean bean) {
//		List<PermissionsBean> result = null;
//		if(bean!=null && bean.getId()!=0) {
//			PermissionsBean temp = (PermissionsBean) Dao.select();
//			if(temp!=null) {
//				result = new ArrayList<PermissionsBean>();
//				result.add(temp);
//			}
//		} else {
//			result = Dao.select(); 
//		}
//		return result;
//	}

}
