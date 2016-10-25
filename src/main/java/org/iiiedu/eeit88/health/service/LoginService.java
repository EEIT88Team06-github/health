package org.iiiedu.eeit88.health.service;

import java.util.HashMap;
import java.util.Map;

import org.iiiedu.eeit88.health.bean.MemberBean;
import org.iiiedu.eeit88.health.dao.LoginDao;

public class LoginService {
	
	public LoginDao dao;
	
	public Map<String, Object> checkLogin(String account, String password){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		dao = new LoginDao();
		MemberBean member = dao.getMemberByAccount(account);
		if(member.getAccount() == null){//查無帳號
			returnMap.put("checkAccountType", "0");
			returnMap.put("checkAccountErrMsg", "查無帳號");
		}else{
			if(!password.equals(member.getPasswords())){//密碼不同
				returnMap.put("checkAccountType", "1");
				returnMap.put("checkAccountErrMsg", "密碼錯誤");
			}else{
				returnMap.put("checkMember", member);
			}
		}
		
		
		return returnMap; 
	}

}
