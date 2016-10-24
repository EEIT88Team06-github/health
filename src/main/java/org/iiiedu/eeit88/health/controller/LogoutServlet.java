package org.iiiedu.eeit88.health.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.bean.MemberBean;

@WebServlet("/logout.do")
public class LogoutServlet  extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("LoginOK") != null){
			MemberBean logoutMember = (MemberBean)session.getAttribute("LoginOK");
			String logoutId = logoutMember.getAccount();
			//導回index;
			System.out.println(">>>>>>>登出成功,userAccount :"+logoutId);
			session.removeAttribute("LoginOK");
		}
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		return;
	}

}
