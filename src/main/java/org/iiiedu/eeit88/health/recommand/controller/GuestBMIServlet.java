package org.iiiedu.eeit88.health.recommand.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.food.model.CookbookBean;
import org.iiiedu.eeit88.health.recommand.service.GuestRecommandFoodService;
import org.iiiedu.eeit88.health.recommand.service.GuestRecommandSportService;
import org.iiiedu.eeit88.health.sport.model.SportBean;




@WebServlet("/recommands/guest/calculaties/guestbmi.do")
public class GuestBMIServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("AAA");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession(false); // 取出session物件	
		Map<String,String> errorMsg = new HashMap<>();
		session.setAttribute("error", errorMsg);
		Map<String,String> paramMsg = new HashMap<>();
		session.setAttribute("backFill", paramMsg);
		
		//1.接收資料
		String tempHeight = request.getParameter("heights");
		paramMsg.put("height", tempHeight);
		String tempWeight = request.getParameter("weights");
		paramMsg.put("weight", tempWeight);
		String gender = request.getParameter("gender");
		paramMsg.put("gender", gender);
		String recommand = request.getParameter("recommand");
		paramMsg.put("recommand", recommand);
		System.out.println(tempHeight+" "+tempWeight+" "+gender+" "+recommand);
		
				
		//2.驗證資料		
		if(tempHeight==null || tempHeight.trim().length()==0){
			errorMsg.put("height", "必填");
		}
		
		if(tempWeight==null || tempWeight.trim().length()==0){
			errorMsg.put("weight", "必填");
		}
		
		if(gender==null || gender.trim().length()==0){
			errorMsg.put("gender", "請勾選性別");
		}
		
		if(recommand==null || recommand.trim().length()==0){
			errorMsg.put("recommand", "請勾選性別");
		}

		
		//3.轉換資料
		float height = 0;
		if (tempHeight != null && tempHeight.trim().length() > 0) {
			try{
				height = Float.parseFloat(tempHeight);
			}catch (NumberFormatException e) {
				errorMsg.put("height", "格式錯誤");
			}
		}
			
		float weight = 0;
		if (tempWeight != null && tempWeight.trim().length() > 0) {
			try{
				weight = Float.parseFloat(tempWeight);
			}catch (NumberFormatException e) {
				errorMsg.put("weight", "格式錯誤");
			}
		}			
		//System.out.println(height+weight);
		
		
		//3.1若資料有誤打回原頁面，!!!!注意：要緊接著在驗證、轉換資料後
		
		//以換成jQuery dialog 驗證須導回????
		if (!errorMsg.isEmpty()) {
			response.sendRedirect(request.getContextPath()+"/recommands/home.jsp");
//			response.sendRedirect(request.getContextPath()+"/recommands/guest/calculaties.jsp");
//			request.getRequestDispatcher("/recommands/guest/calculaties.jsp").forward(request, response);
			return;
		}

		
		//4.邏輯運算
		
		if(recommand.equals("food")){
			GuestRecommandFoodService food = new GuestRecommandFoodService();  //設計模型：facade
			CookbookBean bean = food.recommand(height, weight, gender);
			//System.out.println(bean);
			//request.setAttribute("recommand", bean);
			session.setAttribute("recommand", bean);
			
			//5.根據結果導向view
			//request.getRequestDispatcher("/recommands/guest/foods.jsp").forward(request, response);  //如果重整不要重複推薦給他
			response.sendRedirect(request.getContextPath()+"/recommands/guest/foods.jsp");
			return;	
		}else if(recommand.equals("sport")){
			GuestRecommandSportService sport = new GuestRecommandSportService();  //設計模型：facade
			SportBean bean = sport.recommand(height, weight, gender);
			//System.out.println(bean);
			//request.setAttribute("recommand", bean);
			session.setAttribute("recommand", bean);
			
			//5.根據結果導向view
			//request.getRequestDispatcher("/recommands/guest/sports.jsp").forward(request, response);  //如果重整不要重複推薦給他
			response.sendRedirect(request.getContextPath()+"/recommands/guest/sports.jsp");
			return;	
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
