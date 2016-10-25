package org.iiiedu.eeit88.health.MembersOnly.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.MembersOnly.model.accountBean;
import org.iiiedu.eeit88.health.MembersOnly.model.accountService;

/**
 * Servlet implementation class bonusServlt
 */
@WebServlet("/MembersOnly/bonus")
public class bonusServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  accountService as = new accountService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		//-------------------------------------------		
		
		int id = 6;		
		
		//--------------------------------------------
		
		Integer bonus = as.select(id).getBonus();
		request.setAttribute("bonusT", bonus);
		request.getRequestDispatcher("/MembersOnly/bonus.jsp").forward(request, response);
		return;
	}
}
