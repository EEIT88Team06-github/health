package org.iiiedu.eeit88.health.calories.service;

import java.util.List;

import org.iiiedu.eeit88.health.food.model.FoodBean;
import org.iiiedu.eeit88.health.food.model.FoodDAO;
import org.iiiedu.eeit88.health.food.model.dao.FoodDAOJdbc;



public class ShowFoodsService {
	private FoodDAO food = new FoodDAOJdbc();
	public List<FoodBean> showForUser(){  //狀態為true的表示上架，使用者可看
		List<FoodBean> result = null;	
		result = food.selectStatus(true);
		return result;
	}
	
	
	//for test 
	public static void main(String[] args){
		ShowFoodsService test = new ShowFoodsService();
		System.out.println(test.showForUser());
	}
}
