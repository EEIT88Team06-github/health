package org.iiiedu.eeit88.health.memberrecord.service;

import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.food.model.AbsorbBean;
import org.iiiedu.eeit88.health.food.model.AbsorbChartBean;
import org.iiiedu.eeit88.health.food.model.AbsorbDAO;
import org.iiiedu.eeit88.health.food.model.AbsorbDetailBean;
import org.iiiedu.eeit88.health.food.model.AbsorbDetailDAO;
import org.iiiedu.eeit88.health.food.model.DateBean;
import org.iiiedu.eeit88.health.food.model.DateDAO;
import org.iiiedu.eeit88.health.food.model.FoodDAO;
import org.iiiedu.eeit88.health.food.model.dao.AbsorbDAOJdbc;
import org.iiiedu.eeit88.health.food.model.dao.AbsorbDetailDAOJdbc;
import org.iiiedu.eeit88.health.food.model.dao.DateDAOJdbc;
import org.iiiedu.eeit88.health.food.model.dao.FoodDAOJdbc;



public class ShowAbsorbDataHistoryService {

	private AbsorbDAO absorb = new AbsorbDAOJdbc();
	private DateDAO date = new DateDAOJdbc();
	private AbsorbDetailDAO absorbDetail = new AbsorbDetailDAOJdbc();
	private FoodDAO food = new FoodDAOJdbc();
	
	
	public List<AbsorbChartBean> chart(int memId,String startDay,String endDay){
		List<AbsorbChartBean> result = null;
		List<String> selectDate = new ArrayList<String>();
		String absorbDate = null;
		float foodCalories = 0;
		
		//1.將使用者所選的時間區間裡的每一天全選出
		List<DateBean> dateBean = date.select(startDay, endDay);  
		for(int i=0;i<dateBean.size();i++){
			java.util.Date tempSelectDate = dateBean.get(i).getDate();  //將使用者所選的時間區間拿出
			String addSelectDate = String.valueOf(tempSelectDate);
			selectDate.add(addSelectDate);
		}
		
		//2.取出每一天裡的每一筆記錄，並將明細列出算熱量
		result = new ArrayList<AbsorbChartBean>();
		
		for(int i=0;i<selectDate.size();i++){
			AbsorbChartBean bean = new AbsorbChartBean();
			List<AbsorbBean> absorbBeans =absorb.selectByDate(memId, selectDate.get(i));  //取出每一個日期的紀錄
			//System.out.println("absorbBeans= "+absorbBeans);
			//System.out.println(absorbBeans.size());
			if(absorbBeans.size()==0){  //如果yyyy/MM/dd沒有資料就塞一筆資料給他(yyyy/MM/dd,0 Kcal)
				bean = new AbsorbChartBean(selectDate.get(i),new Float(0));
				result.add(bean);
				
			}else{
				List<Integer> absorbIds = new ArrayList<Integer>();  //this is in here 因為是要取出某一天裡的每一筆記錄
				for(int j=0;j<absorbBeans.size();j++){
					int absorbId = absorbBeans.get(j).getId();  //取得所有屬於yyyy/MM/dd的資料
					absorbIds.add(absorbId);	
				}// end of for(J)
				int quantity = 0;
				float tempCalories = 0;
				for(int k=0;k<absorbIds.size();k++){
					List<AbsorbDetailBean> beans = absorbDetail.select(absorbIds.get(k));  //System.out.println(absorbDetail.select(absorbIds.get(k))); //取得所有屬於yyyy/MM/dd的細項資料
					//System.out.println("AbsorbDetailBean"+beans);  //System.out.println(beans.size());
					
					for(int l=0;l<beans.size();l++){
						quantity = beans.get(l).getQuantity();  //System.out.println("quantity= "+quantity);
						int foodId = beans.get(l).getFoodId(); //System.out.println("foodId= "+foodId);
						float calories = food.select(foodId).getCalories();  //System.out.println("calories= "+calories);
						tempCalories = tempCalories + quantity*calories;  //System.out.println("tempCalories= "+tempCalories); 		
					}	
				}//end of for(K)
				foodCalories =  tempCalories;
				//System.out.println(foodCalories);
				bean = new AbsorbChartBean(selectDate.get(i),foodCalories);  //System.out.println("bean= "+bean);
				result.add(bean);
			}
		}//end of for(I)
		//System.out.println(result);
		return result;
	}  //end of chart
	
	
	
	
	//for test 
	public static void main(String[] args){
		ShowAbsorbDataHistoryService test = new ShowAbsorbDataHistoryService();
		test.chart(1, "2016-10-11", "2016-10-13");
	}
}//end of class
