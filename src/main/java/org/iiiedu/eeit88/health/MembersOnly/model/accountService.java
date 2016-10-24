package org.iiiedu.eeit88.health.MembersOnly.model;

import org.iiiedu.eeit88.health.MembersOnly.model.dao.accountDAODS;

public class accountService {
	private accountDAO Dao = new accountDAODS();

	public accountBean select(int id){
		accountBean result = Dao.select(id);
		
		
		return result;
	}


	
	public  accountBean update(accountBean bean){
		accountBean result = null;
		if(bean!=null) {
			result = Dao.update(
//					bean.getPasswords(), 
					bean.getLastname(), 
					bean.getFirstname(), 
					bean.getNickname(),
					bean.getPhone(), 
					bean.getPair(), 
					bean.getCity(),
					bean.getConunty(),
					bean.getAddr(),
//					bean.getPicture(),
					bean.getId());										
						
					}return result;
				}
}		
//	public List<accountBean> select(accountBean bean) {
//		List<accountBean> result = null;
//		if(bean!=null && bean.getId()!=0) {
//			accountBean temp = Dao.select(bean.getId());
//			if(temp!=null) {
//				result = new ArrayList<accountBean>();
//				result.add(temp);
//			}
//		} else {
//			result = Dao.select(); 
//		}
//		return result;
//	}
	
//	public accountService(accountDAO accountDao) {
//		this.accountDao = accountDao;
//	}
	
//	public static void main(String[] args) {
//		accountService service = new accountService();
//		List<accountBean> beans = service.select();
//		System.out.println("beans="+beans);
//	}
	
//	public static void main(String[] args){
//	accountService service = new accountService();
//	int id = 5;
//	accountBean bean = new accountBean();
//	System.out.println(service.select(id)); 
//	System.out.println(at);
//	}
	

