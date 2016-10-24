package org.iiiedu.eeit88.health.MembersOnly.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.MembersOnly.model.collsubBean;
import org.iiiedu.eeit88.health.MembersOnly.model.collsubService;

@WebServlet("/MembersOnly/collect")
public class collectServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private  collsubService cs = new collsubService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		
		collsubBean bean = new collsubBean(); 
		List<collsubBean> result = cs.select(5);
		request.setAttribute("csAll", result);
		request.getRequestDispatcher("/MembersOnly/collect.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
