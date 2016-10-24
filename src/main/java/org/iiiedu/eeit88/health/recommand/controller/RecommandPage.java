package org.iiiedu.eeit88.health.recommand.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.bean.MemberBean;


@WebServlet("/recommands/validate.do")
public class RecommandPage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("do");
		
		request.setCharacterEncoding("UTF-8");//輸入資料的編碼
		response.setContentType("text/html; charset=utf-8");
		
		
		//確認是否有會員登入成功的字串
		HttpSession session = request.getSession(false);  //取
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");  //loginToken
	
		if(mb==null){  //如果會員沒登入
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/recommands/guest/home.jsp"));
			return;
		}else{
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/recommands/member/home.jsp"));
			return;
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
