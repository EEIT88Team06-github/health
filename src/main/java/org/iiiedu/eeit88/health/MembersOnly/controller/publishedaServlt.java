package org.iiiedu.eeit88.health.MembersOnly.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.MembersOnly.model.subjectBean;
import org.iiiedu.eeit88.health.MembersOnly.model.subjectService;

/**
 * Servlet implementation class publishedaServlt
 */
@WebServlet("/MembersOnly/pdsubject")
public class publishedaServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private  subjectService ss = new subjectService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		subjectBean bean = new subjectBean(); 
//		List<subjectBean> result = ss.select(memid);
		List<subjectBean> result = ss.select(5);
		request.setAttribute("ssAll", result);
		request.getRequestDispatcher("/MembersOnly/publisheda.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
