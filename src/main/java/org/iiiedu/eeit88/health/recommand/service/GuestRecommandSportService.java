package org.iiiedu.eeit88.health.recommand.service;

import org.iiiedu.eeit88.health.sport.model.SportBean;
import org.iiiedu.eeit88.health.sport.model.SportDAO;
import org.iiiedu.eeit88.health.sport.model.dao.SportDAOJdbc;

public class GuestRecommandSportService {
	private BMICalculateService bmi = new BMICalculateService();
	private SportDAO sport = new SportDAOJdbc();
	public SportBean recommand(float height,float weight,String gender){
		SportBean result = null;
		
		String bmiResult = bmi.functionBMI(height, weight, gender);

		//要取 n~m 就是 亂數＊( m - n + 1) + n
		if(bmiResult.equals("過輕")){  
			int i = (int)(Math.random()*3+1);  //1-3
			result = sport.select(i);
		}else if(bmiResult.equals("適中")){
			int i = (int)(Math.random()*5+4);  //4-8
			result = sport.select(i);
		}else if(bmiResult.equals("過胖")){
			int i = (int)(Math.random()*5+9);  //9-13
			result = sport.select(i);
		}
		return result;
	}
	

	//for test
	public static void main(String[] args) {
		

	}
}
