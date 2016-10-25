package org.iiiedu.eeit88.health.match.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iiiedu.eeit88.health.DbUtils.DbConnection;
import org.iiiedu.eeit88.health.match.bean.MatchBean;
import org.iiiedu.eeit88.health.match.dao.MatchDAO;
import org.iiiedu.eeit88.health.match.jdbc.MatchDAOJdbc;

public class MatchService {
	
	private MatchDAO matchDao = new MatchDAOJdbc();
	
	public List<MatchBean> select(MatchBean bean) {
		List<MatchBean> result = null;
		if(bean!=null && bean.getId()!=0) {
			MatchBean temp = matchDao.getMemberBirth(bean.getAccount());
			if(temp!=null) {
				result = new ArrayList<MatchBean>();
				result.add(temp);
			}
		} else {
			result = matchDao.getMemberBirth(); 
			
		}
		return result;
	}
	public static void main(String[] args) {	
		MatchDAOJdbc dao = new MatchDAOJdbc();
		MatchBean result = dao.getMemberBirth("sumo");
		System.out.println(result);
		
		
	}
	
	
	
	
	
/*	public static void main(String[] args) throws ParseException{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = df.parse("1990-06-21");	
		Calendar nowCal = Calendar.getInstance();
		Calendar birthdayCal = Calendar.getInstance();
		birthdayCal.setTime(birthday);
		int age = nowCal.get(Calendar.YEAR) - birthdayCal.get(Calendar.YEAR) ;
		//判斷年紀只有這裡要注意，就是今年的生日過了沒，沒過就少算一歲。
		birthdayCal.set(Calendar.YEAR,nowCal.get(Calendar.YEAR));
		if(nowCal.getTime().getTime()<birthdayCal.getTime().getTime()){
		  age--;
		}
		System.out.println(age+" years old");
	}
	
	*/	
		

}
