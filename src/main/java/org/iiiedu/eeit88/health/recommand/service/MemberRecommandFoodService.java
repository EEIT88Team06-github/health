package org.iiiedu.eeit88.health.recommand.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.iiiedu.eeit88.health.food.model.CookRecommandBean;
import org.iiiedu.eeit88.health.food.model.CookRecommandDAO;
import org.iiiedu.eeit88.health.food.model.CookbookBean;
import org.iiiedu.eeit88.health.food.model.CookbookDAO;
import org.iiiedu.eeit88.health.food.model.dao.CookRecommandDAOJdbc;
import org.iiiedu.eeit88.health.food.model.dao.CookbookDAOJdbc;
import org.iiiedu.eeit88.health.member.dao.MemberDAO;





public class MemberRecommandFoodService {
	private BMICalculateService bmi = new BMICalculateService();  
	private CookbookDAO canRecommand = new CookbookDAOJdbc();  //可推薦的
	private CookRecommandDAO alreadyRecommand = new CookRecommandDAOJdbc();  //已推薦過的
	private MemberDAO dao = new MemberDAO();
	
	public CookbookBean recommand(int id){
		CookbookBean result = null;
		
		CookRecommandBean record = alreadyRecommand.select(id);
		System.out.println(record);
		
		if(record!=null){
			//判斷上次時間
			//判斷上次推薦時間，若是今天就告訴她已推薦過
			java.util.Date lastRecommandDate = alreadyRecommand.select(id).getCookRecommandDate();//會印出memid裡最近(後)一筆的資料
			String date = String.valueOf(lastRecommandDate);  //將時間轉換成字串方便比較
			System.out.println(date);  
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String now = sdf.format(new java.util.Date());
			System.out.println(now);
			
			if(date.equals(now)){
				System.out.println("今天已推薦過了");
				result = null;
			}else {
				
				//抓出會員資料、算BMI、以及他的身材(胖中瘦)
				Float height = dao.select(id).getHeight();
				Float weight = dao.select(id).getWeights();
				String gender = dao.select(id).getGender();
				System.out.println(height +" "+ weight +" " + gender);
				String bmiResult = bmi.functionBMI(height, weight, gender);  //胖?中?瘦?
				System.out.println(bmiResult);
				
				
				//撈出可推薦的跟已推薦過的、比對出尚未推薦過的、從尚未推薦過的隨機挑一筆推薦
				try {
					List<Integer> can = canRecommand.selectSuit(bmiResult);  //可推薦的
					System.out.println(can);
					List<Integer> already = alreadyRecommand.selectAll(id);  //已推薦過
					System.out.println(already);
					
					List<Integer> difference = new ArrayList<Integer>();
					difference.addAll(can);  //將可推薦全加入
					difference.removeAll(already);  //移除掉already有出現過的
					System.out.println(difference); 
					
					int x = difference.size();  //if x=3
					//要取 n~m 就是 亂數＊( m - n + 1) + n  (if x=3,need=>0-2)
					int random = (int)(Math.random()*x); 
					int recommand = difference.get(random);
					System.out.println(recommand);
					
					result = canRecommand.select(recommand);  //此次推薦
					System.out.println(result);
					
					
					//將此次推薦存入資料庫
					CookRecommandBean bean = alreadyRecommand.insert(new java.util.Date(), result.getId(), id);
					System.out.println(bean);
				} catch (Exception e) {
					System.out.println("我已經沒有東西可以推薦給你了!!!");
				}		
			}
		}else if(record==null){
			//第一次所以可以推薦
			//抓出會員資料、算BMI、以及他的身材(胖中瘦)
			Float height = dao.select(id).getHeight();
			Float weight = dao.select(id).getWeights();
			String gender = dao.select(id).getGender();
			System.out.println(height +" "+ weight +" " + gender);
			String bmiResult = bmi.functionBMI(height, weight, gender);  //胖?中?瘦?
			System.out.println(bmiResult);
			
			List<Integer> can = canRecommand.selectSuit(bmiResult);
			System.out.println(can);
			int x = can.size();  //if x=3
			//要取 n~m 就是 亂數＊( m - n + 1) + n  (if x=3,need=>0-2)
			int random = (int)(Math.random()*x); 
			int recommand = can.get(random);
			System.out.println(recommand);
			
			result = canRecommand.select(recommand);  //此次推薦
			System.out.println(result);
			
			//將此次推薦存入資料庫
			CookRecommandBean bean = alreadyRecommand.insert(new java.util.Date(), result.getId(), id);
			System.out.println(bean);
		}
			return result;
		}  //end of recommand
		
	//for test
	public static void main(String[] args) {
		MemberRecommandFoodService test = new MemberRecommandFoodService();
//		test.recommand(3);  //過胖
		test.recommand(1);
	}

}
