package org.iiiedu.eeit88.health.match.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.match.bean.MatchBean;
import org.iiiedu.eeit88.health.match.service.MatchService;

	@WebServlet("/match/Match.do")
	public class MatchServlet extends HttpServlet {
		private MatchService matchService = new MatchService();
		private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}
		public void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
			// 說明瀏覽器送來之文字資料的編碼
			request.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession();
			Date birth = ((MatchBean)session.getAttribute("LoginOK")).getBirth();
			
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			String sbirth=birth.toString();
			
			java.util.Date mydate = null;
			try {
				mydate = myFormatter.parse(sbirth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Date today=new Date();
			
			  long day=(today.getTime()-mydate.getTime())/(24*60*60*1000) + 1;
			  String year=new java.text.DecimalFormat("#.00").format(day/365f);
			System.out.println("niu:" + year.substring(0, 2));
			
			request.setAttribute("age", year.substring(0, 2));
		    
			
			RequestDispatcher rd = request.getRequestDispatcher("../pickout.jsp");
			rd.forward(request, response);		
			
			
			
			
			return;	
		}
		
	}


