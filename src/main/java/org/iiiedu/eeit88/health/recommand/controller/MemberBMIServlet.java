package org.iiiedu.eeit88.health.recommand.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.food.model.CookbookBean;
import org.iiiedu.eeit88.health.member.model.MemberBean;
import org.iiiedu.eeit88.health.recommand.service.MemberRecommandFoodService;
import org.iiiedu.eeit88.health.recommand.service.MemberRecommandSportService;
import org.iiiedu.eeit88.health.sport.model.SportBean;




@WebServlet("/recommands/memberbmi.do")
public class MemberBMIServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Member BMI Recommand");
		request.setCharacterEncoding("UTF-8");//輸入資料的編碼
		response.setContentType("text/html; charset=utf-8");
		
		//確認是否有會員登入成功的字串
		HttpSession session = request.getSession(); // 取出session物件
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");  //loginToken
		
//		if (mb == null) {  
//			response.sendRedirect(response.encodeRedirectURL("/TestTwo/recommands/guest/calculaties.jsp"));
//			return;
//		}

//		Integer id = mb.getId();
		Integer id = 2;
		
		String recommand = (String) session.getAttribute("recommand");  //System.out.println(recommand);
		
		if(recommand.equals("food")){
			MemberRecommandFoodService food = new MemberRecommandFoodService();
			CookbookBean bean = food.recommand(id);
			if(bean==null){
				//System.out.println("Today is already recommand");
				response.sendRedirect(request.getContextPath()+"/recommands/member/alreadyrecommand.jsp");
				return;
			}else{
				session.setAttribute("recommand", bean);
				//request.setAttribute("recommand", bean);
				
				response.sendRedirect(request.getContextPath()+"/recommands/member/foods.jsp");  //Dont't Forget use session
				//request.getRequestDispatcher("/recommands/foods.jsp").forward(request, response);//網址不會變停留在sevlet裡，重整東西會重新insert進資料庫並不適合
				return;
			}
				
		}else if(recommand.equals("sport")){
			MemberRecommandSportService sport = new MemberRecommandSportService();
			SportBean bean = sport.recommand(id);
			if(bean==null){
				//System.out.println("Today is already recommand");
				response.sendRedirect(request.getContextPath()+"/recommands/member/alreadyrecommand.jsp");
				return;
			}else{
				session.setAttribute("recommand", bean);
				//request.setAttribute("recommand", bean);
				
				response.sendRedirect(request.getContextPath()+"/recommands/member/sports.jsp");  //Dont't Forget use session
				//request.getRequestDispatcher("/recommands/sports.jsp").forward(request, response);//網址不會變停留在sevlet裡，重整東西會重新insert進資料庫並不適合
				return;
			}
		}
		
			
		
		
		


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
