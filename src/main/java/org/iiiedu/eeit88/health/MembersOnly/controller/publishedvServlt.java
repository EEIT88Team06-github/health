package org.iiiedu.eeit88.health.MembersOnly.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.MembersOnly.model.movieBean;
import org.iiiedu.eeit88.health.MembersOnly.model.movieService;
import org.iiiedu.eeit88.health.MembersOnly.model.subjectBean;


@WebServlet("/MembersOnly/pvmovie")
public class publishedvServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  movieService ms = new movieService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
//		List<movieBean> result = ms.select(memid);
		
		
		
		movieBean bean = new movieBean(); 
		List<movieBean> result = ms.select(5);
		request.setAttribute("msAll", result);
		request.getRequestDispatcher("/MembersOnly/publishedv.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
