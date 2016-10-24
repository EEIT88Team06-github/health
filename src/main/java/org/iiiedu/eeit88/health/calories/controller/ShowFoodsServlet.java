package org.iiiedu.eeit88.health.calories.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.calories.service.ShowFoodsService;
import org.iiiedu.eeit88.health.food.model.FoodBean;



@WebServlet("/calculaties/food/showfood.do")
public class ShowFoodsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession(false); // 取出session物件
		
//		if(session == null){  //連線逾時
//			response.sendRedirect(request.getContextPath()+"/login.jsp");
//			return;	
//		}
		
//		//確認是否登入
//		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");  //loginToken
//		
//		if (mb == null) {  
//			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/login.jsp"));
//			return;
//		}
		
		
		
		//1.接收資料
		//2.驗證資料
		//3.轉換資料
		//4.執行邏輯
			ShowFoodsService show = new ShowFoodsService();
			List<FoodBean> beans = show.showForUser();
			request.setAttribute("ALLFOOD", beans);
		//5.顯示畫面
			request.getRequestDispatcher("/calculaties/food/calories.jsp").forward(request, response);
			return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
