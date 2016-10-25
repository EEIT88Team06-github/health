package org.iiiedu.eeit88.health.memberrecord.service;

import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.food.model.AbsorbBean;
import org.iiiedu.eeit88.health.food.model.AbsorbDAO;
import org.iiiedu.eeit88.health.food.model.AbsorbDetailBean;
import org.iiiedu.eeit88.health.food.model.AbsorbDetailDAO;
import org.iiiedu.eeit88.health.food.model.AbsorbShowBean;
import org.iiiedu.eeit88.health.food.model.FoodDAO;
import org.iiiedu.eeit88.health.food.model.dao.AbsorbDAOJdbc;
import org.iiiedu.eeit88.health.food.model.dao.AbsorbDetailDAOJdbc;
import org.iiiedu.eeit88.health.food.model.dao.FoodDAOJdbc;



public class ShowAbsorbHistoryService {
	private AbsorbDAO absorb = new AbsorbDAOJdbc();
	private AbsorbDetailDAO absorbDetail = new AbsorbDetailDAOJdbc();
	private FoodDAO food = new FoodDAOJdbc();
	
	
	public List<AbsorbShowBean> show(int memId,String startDay,String endDay){
		List<AbsorbShowBean> result = null;
		
		//1.取得在某段時間的某會員所攝取
		//(1)總項
		List<Integer> absorbIds = new ArrayList<Integer>();
		List<AbsorbBean> bean = absorb.selectByDate(memId, startDay, endDay);
		System.out.println(bean);
		for(int i=0;i<bean.size();i++){
			absorbIds.add(bean.get(i).getId());	
		}//System.out.println(absorbBean);  //執行完畢得到absorbIds
		
		//(2)細項
		List<AbsorbDetailBean> absorbDetails = new ArrayList<AbsorbDetailBean>();
		for(int i=0;i<absorbIds.size();i++){
			int absorbId = absorbIds.get(i);  //22→23→26
			//System.out.println("absorbId="+absorbId);
			List<AbsorbDetailBean> detailBean = absorbDetail.select(absorbId);
			//System.out.println("detailBean="+detailBean);
			
			for(int j=0;j<detailBean.size();j++){
				//System.out.println("detailBean.get(j)="+detailBean.get(j));
				absorbDetails.add(detailBean.get(j));
			}
		}//System.out.println(absorbDetails);  //執行完畢得到absorbDetails
		
		
		//2.取得攝取份數、攝取時間、食物名稱、卡洛里
		result = new ArrayList<AbsorbShowBean>();
		for(int i=0 ; i<absorbDetails.size();i++){  //absorbDetails的筆數
			AbsorbShowBean show = null;
			int quantity = absorbDetails.get(i).getQuantity();  //取得單筆absorbDetail的攝取份數
			int idToSerchDate = absorbDetails.get(i).getAbsorbId();
			java.util.Date absorbDate = absorb.selectOne(idToSerchDate).getAbsorbDate();//取得單筆absorbDetail的攝取日期
			int idToSerchFood = absorbDetails.get(i).getFoodId();
			String foodName = food.select(idToSerchFood).getName();  //取得單筆absorbDetail的攝取食物名稱
			Float calories = food.select(idToSerchFood).getCalories();//取得單筆absorbDetail的攝取食物卡洛里
			Integer foodId = food.select(idToSerchFood).getId();//取得單筆absorbDetail的攝取食物id
			Float total = Float.valueOf(quantity)*calories;
			show = new AbsorbShowBean(foodName,absorbDate,quantity,calories,total,foodId);	//將單筆記錄封裝到AbsorbShowBean裡頭	
			result.add(show);
		}//System.out.println(result);  //執行完畢得到result (List<AbsorbShowBean>)	
		return result;
	}//end of show

	
	
	//for test
	public static void main(String[] args){
		ShowAbsorbHistoryService test = new ShowAbsorbHistoryService();
		test.show(1, "2016-10-12", "2016-10-13");
	}
	
}
