package org.iiiedu.eeit88.health.calories.service;

import java.util.List;

import org.iiiedu.eeit88.health.sport.model.SportBean;
import org.iiiedu.eeit88.health.sport.model.SportDAO;
import org.iiiedu.eeit88.health.sport.model.dao.SportDAOJdbc;

public class ShowSportsService {
	private SportDAO sport = new SportDAOJdbc();
	public List<SportBean> showForUser(){  //狀態為true的表示上架，使用者可看
		List<SportBean> result = null;	
		result = sport.selectStatus(true);	
		return result;
	}
}
