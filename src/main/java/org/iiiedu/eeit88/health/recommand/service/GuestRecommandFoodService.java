package org.iiiedu.eeit88.health.recommand.service;

import org.iiiedu.eeit88.health.food.model.CookbookBean;
import org.iiiedu.eeit88.health.food.model.CookbookDAO;
import org.iiiedu.eeit88.health.food.model.dao.CookbookDAOJdbc;

public class GuestRecommandFoodService {
	
	private BMICalculateService bmi = new BMICalculateService();
	private CookbookDAO recommandFood = new CookbookDAOJdbc();
	public CookbookBean recommand(float height,float weight,String gender){
		CookbookBean result = null;
		
		String bmiResult = bmi.functionBMI(height, weight, gender);

		//要取 n~m 就是 亂數＊( m - n + 1) + n
		if(bmiResult.equals("過輕")){  
			int i = (int)(Math.random()*3+1);  //1-3
			result = recommandFood.select(i);
		}else if(bmiResult.equals("適中")){
			int i = (int)(Math.random()*5+4);  //4-8
			result = recommandFood.select(i);
		}else if(bmiResult.equals("過胖")){
			int i = (int)(Math.random()*5+9);  //9-13
			result = recommandFood.select(i);
		}

		
		return result;
	}
	

	//for test
	public static void main(String[] args) {
		

	}

}
