package org.iiiedu.eeit88.health.calories.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.calories.service.AbsorbCart;

@WebServlet("/calculaties/food/checkCalories.do")
public class CheckFoodCalories extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession(false); // 取出session物件
		//確認是否登入
//		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");  //loginToken
//		
//		if (mb == null) {  
//			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/index.jsp"));
//			return;
//		}
		
		AbsorbCart cart = (AbsorbCart) session.getAttribute("AbsorbCart");
		if(cart == null){
			cart = new AbsorbCart();
			session.setAttribute("AbsorbCart", cart);
		}
		
		int num = cart.getItemNumber();

		//System.out.println(num);
		
		
		if(num>0){
			PrintWriter out = response.getWriter();
			out.print("目前熱量總合為："+cart.getTotal()+"kcal");
		}else{
			PrintWriter out = response.getWriter();
			out.print("您尚未選取任何食物");
		}
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
