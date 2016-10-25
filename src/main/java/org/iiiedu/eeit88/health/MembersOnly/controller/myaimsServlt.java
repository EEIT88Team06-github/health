package org.iiiedu.eeit88.health.MembersOnly.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.MembersOnly.model.accountBean;
import org.iiiedu.eeit88.health.MembersOnly.model.accountService;
import org.iiiedu.eeit88.health.MembersOnly.model.goalBean;
import org.iiiedu.eeit88.health.MembersOnly.model.goalService;


@WebServlet("/MembersOnly/myaims")
public class myaimsServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private goalService gs = new goalService();
	private  accountService as = new accountService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int id = 6;		
		int goal = 1;
		goalBean gss = gs.select(goal);
		Integer gl = gss.getGoal();//		目標編號
		Integer gm = gss.getMemid();//		會員編號
		
		
		Float gc = gss.getContent();//		目標內容
		request.setAttribute("ContentText",gc);
		Date gt = gss.getGoaltime();//		建立時間
		request.setAttribute("GoaltimeText",gt);
		
		
		accountBean ass = as.select(id);
		Float ah= ass.getHeight();//		height	身高	
		Float aw= ass.getWeights();//		weights	體重	
		String mg = ass.getGender();
		Date bbD = ass.getBirth();
		
		
		Float bt = aw/((ah/100)*(ah/100));
		request.setAttribute("BmiText",bt);//	BMI
		if(bt<18.5){
			request.setAttribute("BMI1","過輕");
		}else if(24>bt && 18.5==bt) {
			request.setAttribute("BMI1","正常");
		}else if(bt>24 && 27>=bt){
			request.setAttribute("BMI1","過重");
		}else if (bt>27 && 30>=bt) {
			request.setAttribute("BMI1","輕度肥胖");
		}else if(bt>30 && 35>=bt){
			request.setAttribute("BMI1","中度肥胖");
		}else {
			request.setAttribute("BMI1","重度肥胖");
		}

		java.util.Date i = new java.util.Date();
		@SuppressWarnings("deprecation")
		int Year = i.getYear()+1900;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = sdf.format(bbD);
		String Bir = dateString.substring(0,4);
		
		int y1 = Integer.parseInt(Bir);
		
		int bh = y1-Year;
		
		String m = "m";
		if(mg.equals(m)){
			float BMR1 = (float) ((13.7*aw)+(5*ah)-(6.8*bh)+66);
			request.setAttribute("BMR1",BMR1);
		}else {
			float BMR1 = (float) ((9.6*aw)+(1.8*ah)-(4.7*bh)+655);
			request.setAttribute("BMR1",BMR1);
		}
		
//		基礎代謝率
//		BMR(男)=(13.7×體重(公斤))+(5.0×身高(公分))-(6.8×年齡)+66
//		BMR(女)=(9.6×體重(公斤))+(1.8×身高(公分))-(4.7×年齡)+655
		
		
		int goodBMI2 = (int) (24*((ah/100)*(ah/100)));
		int goodBMI1 = (int) (18.5*((ah/100)*(ah/100)));
		
		request.setAttribute("gBMI1",goodBMI1);
		request.setAttribute("gBMI2",goodBMI2);
		
//		float okaw = newwb - aw;
//		
//		String prodaction = request.getParameter("prodaction");
//		if("Insert".equals(prodaction) || "Update".equals(prodaction) || "Delete".equals(prodaction)) {
//			if(id==0) {
//				errors.put("id", "請輸入Id以便於執行"+prodaction);
//			}
//		}
//		if("Insert".equals(prodaction)) {
//			ProductBean result = productService.insert(bean);
//			if(result==null) {
//				errors.put("action", "新增資料失敗");
//			} else {
//				request.setAttribute("insert", result);
//			}
//			request.getRequestDispatcher(
//					"/pages/product.jsp").forward(request, response);
//			
			
		request.getRequestDispatcher("/MembersOnly/myaims.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
