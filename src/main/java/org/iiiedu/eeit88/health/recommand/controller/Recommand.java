package org.iiiedu.eeit88.health.recommand.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.bean.MemberBean;



@WebServlet("/recommands/what.do")
public class Recommand extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("do");
		
		request.setCharacterEncoding("UTF-8");//輸入資料的編碼
		response.setContentType("text/html; charset=utf-8");
		
		
		//確認是否有會員登入成功的字串
		HttpSession session = request.getSession(false);  //取
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");  //loginToken
		
		
		String recommand = request.getParameter("recommand");
		//System.out.println(recommand);
		
		if(recommand.equals("food")){
			//System.out.println("select food");
			session.setAttribute("recommand", recommand);//recommand=food	
			if(mb==null){  //如果會員沒登入
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/recommands/guest/home.jsp"));
				return;
			}else{
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/recommands/memberbmi.do"));
				return;
			}
		
			
		}else if(recommand.equals("sport")){
			//System.out.println("select sport");
			session.setAttribute("recommand", recommand);//recommand=sport
			if(mb==null){  //如果會員沒登入	
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/recommands/guest/home.jsp"));
				return;
			}else{
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/recommands/memberbmi.do"));
				return;
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
