package org.iiiedu.eeit88.health.match.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.match.bean.MatchBean;




	@WebServlet("/match/Search.do")
	public class SearchServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}
		public void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
			// 說明瀏覽器送來之文字資料的編碼
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
		    
			String[] ssex = request.getParameterValues("sex");
			String city = request.getParameter("city");
			String country = request.getParameter("country");
		    // 將四樣資訊裝入CustomerBean型別的物件cust內		
			MatchBean cust = new MatchBean(ssex,city,country);
		    // 將cust物件暫存到請求物件內，成為它的屬性物件，屬性物件可以與別的程式共用。		
			session.setAttribute("matchbean",cust);
	        // 程式的執行順序移轉到/ch02/displayCustomerInfo.jsp內
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("../search.jsp");
			rd.forward(request, response);		
			
			
			
			
			return;	
		}
		
	}


