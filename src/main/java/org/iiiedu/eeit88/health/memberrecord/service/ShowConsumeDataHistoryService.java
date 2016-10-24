package org.iiiedu.eeit88.health.memberrecord.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.iiiedu.eeit88.health.sport.model.ConsumeBean;
import org.iiiedu.eeit88.health.sport.model.ConsumeChartBean;
import org.iiiedu.eeit88.health.sport.model.ConsumeDAO;
import org.iiiedu.eeit88.health.sport.model.ConsumeDetailBean;
import org.iiiedu.eeit88.health.sport.model.ConsumeDetailDAO;
import org.iiiedu.eeit88.health.sport.model.SportDAO;
import org.iiiedu.eeit88.health.sport.model.dao.ConsumeDAOJdbc;
import org.iiiedu.eeit88.health.sport.model.dao.ConsumeDetailDAOJdbc;
import org.iiiedu.eeit88.health.sport.model.dao.SportDAOJdbc;



public class ShowConsumeDataHistoryService {
	private ConsumeDAO consume = new ConsumeDAOJdbc();
	private ConsumeDetailDAO consumeDetail = new ConsumeDetailDAOJdbc();
	private SportDAO sport = new SportDAOJdbc();

	public List<ConsumeChartBean> chart(int memId, String startDay, String endDay) {
		List<ConsumeChartBean> result = null;

		// 1.將使用者所選的時間區間裡的每一天全選出
		//(1).將收到使用者給的日期格式拆成年、月、日
			String[] temp = startDay.split("/");
			int year = Integer.parseInt(temp[0]);
			int month = Integer.parseInt(temp[1]) - 1; // calendar月份從0開始，所以將要放進去的月份減1
			int date = Integer.parseInt(temp[2]);
	
			String[] temp2 = endDay.split("/");
			int year2 = Integer.parseInt(temp2[0]);
			int month2 = Integer.parseInt(temp2[1]) - 1;
			int date2 = Integer.parseInt(temp2[2])+ 1 ; // 因為我所算的日期要包含最後一天(含endDay當天)

		//(2).格式化日期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 將日期格式化

		//(3).將使用者所輸入之日期塞進Calendar裏頭
			Calendar d1 = Calendar.getInstance(); // 起
			d1.set(year, month, date);
	
			Calendar d2 = Calendar.getInstance(); // 迄
			d2.set(year2, month2, date2);
	
			Calendar duringDay = Calendar.getInstance(); // 中間的每一天
			duringDay.set(year, month, date); // 期間的第一天預設給他我們的起始日
		//這些宣告在這
			String consumeDate = null;
			float sportCalories = 0;
			result = new ArrayList<ConsumeChartBean>();
		
			
		//(4).當中間天在第一天之後;最後一天之前;中間天+1	
		//2.取出每一天裡的每一筆記錄，並將明細列出算熱量	
		
			for (duringDay.after(d1); duringDay.before(d2); duringDay.add(Calendar.DATE, 1)) {
				String selectDay = sdf.format(duringDay.getTime());
				System.out.println(selectDay);
		
				ConsumeChartBean bean = new ConsumeChartBean();
				List<ConsumeBean> consumeBeans =consume.selectByDate(memId, selectDay);  //取出每一個日期的紀錄
				//System.out.println("consumeBeans= "+consumeBeans);
				if(consumeBeans.size()==0){  //如果yyyy/MM/dd沒有資料就塞一筆資料給他(yyyy/MM/dd,0 Kcal)
					bean = new ConsumeChartBean(selectDay,new Float(0));
					result.add(bean);
					
				}else{
					List<Integer> consumeIds = new ArrayList<Integer>();  //this is in here 因為是要取出某一天裡的每一筆記錄
					for(int j=0;j<consumeBeans.size();j++){
						int consumeId = consumeBeans.get(j).getId();  //取得所有屬於yyyy/MM/dd的資料
						consumeIds.add(consumeId);	
					}// end of for(J)
					int quantity = 0;
					float tempCalories = 0;
					for(int k=0;k<consumeIds.size();k++){
						List<ConsumeDetailBean> beans = consumeDetail.select(consumeIds.get(k));  //System.out.println(consumeDetail.select(consumeIds.get(k))); //取得所有屬於yyyy/MM/dd的細項資料
						//System.out.println("ConsumeDetailBean="+beans);  //System.out.println(beans.size());
						
						for(int l=0;l<beans.size();l++){
							quantity = beans.get(l).getQuantity();  //System.out.println("quantity= "+quantity);
							int sportId = beans.get(l).getSportId(); //System.out.println("sportId= "+sportId);
							float calories = sport.select(sportId).getCalories();  //System.out.println("calories= "+calories);
							tempCalories = tempCalories + quantity*calories;  //System.out.println("tempCalories= "+tempCalories); 		
						}	
					}//end of for(K)
					sportCalories =  tempCalories;
					//System.out.println(sportCalories);
					bean = new ConsumeChartBean(selectDay,sportCalories);  //System.out.println("bean= "+bean);
					result.add(bean);
				}
				
				System.out.println(result);
			}//end of for(計算所選取之時間的每一天)
		return result;
	}

	// for test
	public static void main(String[] args) {
		ShowConsumeDataHistoryService test = new ShowConsumeDataHistoryService();
		test.chart(1, "2016/10/16", "2016/10/18");
	}
}
