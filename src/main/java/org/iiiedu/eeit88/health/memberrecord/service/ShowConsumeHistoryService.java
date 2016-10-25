package org.iiiedu.eeit88.health.memberrecord.service;

import java.util.ArrayList;
import java.util.List;


import org.iiiedu.eeit88.health.sport.model.ConsumeBean;
import org.iiiedu.eeit88.health.sport.model.ConsumeDAO;
import org.iiiedu.eeit88.health.sport.model.ConsumeDetailBean;
import org.iiiedu.eeit88.health.sport.model.ConsumeDetailDAO;
import org.iiiedu.eeit88.health.sport.model.ConsumeShowBean;
import org.iiiedu.eeit88.health.sport.model.SportDAO;
import org.iiiedu.eeit88.health.sport.model.dao.ConsumeDAOJdbc;
import org.iiiedu.eeit88.health.sport.model.dao.ConsumeDetailDAOJdbc;
import org.iiiedu.eeit88.health.sport.model.dao.SportDAOJdbc;



public class ShowConsumeHistoryService {
	private ConsumeDAO consume = new ConsumeDAOJdbc();
	private ConsumeDetailDAO consumeDetail = new ConsumeDetailDAOJdbc();
	private SportDAO sport = new SportDAOJdbc();
	
	
	public List<ConsumeShowBean> show(int memId,String startDay,String endDay){
		List<ConsumeShowBean> result = null;
		
		//1.取得在某段時間的某會員所攝取
		//(1)總項
		List<Integer> consumeIds = new ArrayList<Integer>();
		List<ConsumeBean> bean = consume.selectByDate(memId, startDay, endDay);
		System.out.println(bean);
		for(int i=0;i<bean.size();i++){
			consumeIds.add(bean.get(i).getId());	
		}//System.out.println(ConsumeBean);  //執行完畢得到consumeIds
		
		//(2)細項
		List<ConsumeDetailBean> consumeDetails = new ArrayList<ConsumeDetailBean>();
		for(int i=0;i<consumeIds.size();i++){
			int consumeId = consumeIds.get(i);  
			//System.out.println("consumeId="+consumeId);
			List<ConsumeDetailBean> detailBean = consumeDetail.select(consumeId);
			//System.out.println("detailBean="+detailBean);
			
			for(int j=0;j<detailBean.size();j++){
				//System.out.println("detailBean.get(j)="+detailBean.get(j));
				consumeDetails.add(detailBean.get(j));
			}
		}//System.out.println(consumeDetails);  //執行完畢得到consumeDetails
		
		
		//2.取得攝取份數、攝取時間、食物名稱、卡洛里
		result = new ArrayList<ConsumeShowBean>();
		for(int i=0 ; i<consumeDetails.size();i++){  //consumeDetails的筆數
			ConsumeShowBean show = null;
			int quantity = consumeDetails.get(i).getQuantity();  //取得單筆consumeDetail的攝取份數
			int idToSerchDate = consumeDetails.get(i).getConsumeId();
			java.util.Date consumeDate = consume.selectOne(idToSerchDate).getConsumeDate();//取得單筆consumeDetail的攝取日期
			int idToSerchSport = consumeDetails.get(i).getSportId();
			String sportName = sport.select(idToSerchSport).getName();  //取得單筆consumeDetail的攝取食物名稱
			System.out.println(sportName);
			Float calories = sport.select(idToSerchSport).getCalories();//取得單筆consumeDetail的攝取食物卡洛里
			Integer sportId = sport.select(idToSerchSport).getId();//取得單筆consumeDetail的攝取食物id
			Float total = Float.valueOf(quantity)*calories;
			show = new ConsumeShowBean(sportName,consumeDate,quantity,calories,total,sportId);	//將單筆記錄封裝到ConsumeShowBean裡頭
			System.out.println(show);
			result.add(show);
		}//System.out.println(result);  //執行完畢得到result (List<ConsumeShowBean>)	
		return result;
	}//end of show

	
	
	//for test
	public static void main(String[] args){
		ShowConsumeHistoryService test = new ShowConsumeHistoryService();
		test.show(1, "2016-10-12", "2016-10-13");
	}
	
}
