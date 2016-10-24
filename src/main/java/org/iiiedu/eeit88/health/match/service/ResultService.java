package org.iiiedu.eeit88.health.match.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.iiiedu.eeit88.health.DbUtils.DbConnection;
import org.iiiedu.eeit88.health.match.bean.MatchBean;
import org.iiiedu.eeit88.health.match.dao.ResultDAO;
import org.iiiedu.eeit88.health.match.jdbc.MatchDAOJdbc;
import org.iiiedu.eeit88.health.match.jdbc.ResultDAOJdbc;

public class ResultService {
	
public ResultDAOJdbc dao;

//撈出的地區媒合 輸出

public Map<String, Object> checkMatch(String city, String country){
	Map<String, Object> returnMap = new HashMap<String, Object>();
	dao = new ResultDAOJdbc();
	MatchBean member = dao.getCouple("男");
	if(member.getCity() == null){//查無都市
		returnMap.put("checkMatchType", "0");
		returnMap.put("checkMatchErrMsg", "配對失敗");
	}else{
		if(!country.equals(member.getCountry())){//地區不同
			returnMap.put("checkMatchType", "1");
			returnMap.put("checkMatchErrMsg", "地區錯誤");
		}else{
			returnMap.put("checkMember", member);
		}
	}
	
	return returnMap; 
}
}