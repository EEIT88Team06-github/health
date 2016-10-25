package org.iiiedu.eeit88.health.MembersOnly.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.namage.model.PermissionsBean;
import org.iiiedu.eeit88.health.namage.model.PermissionsService;


@WebServlet("/Permissions.do")
public class PermissionsServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PermissionsService PST = new PermissionsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");


		PermissionsBean bean = new PermissionsBean(); 
		List<PermissionsBean> result = PST.select();
		request.setAttribute("PsAll", result);
		System.out.println(result);
		request.getRequestDispatcher("/manage/Permissions.jsp").forward(request, response);
		return;
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
