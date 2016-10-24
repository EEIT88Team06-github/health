package org.iiiedu.eeit88.health.memberrecord.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.bean.MemberBean;
import org.iiiedu.eeit88.health.food.model.AbsorbShowBean;

import org.iiiedu.eeit88.health.memberrecord.service.ShowAbsorbHistoryService;
import org.iiiedu.eeit88.health.memberrecord.service.ShowConsumeHistoryService;
import org.iiiedu.eeit88.health.sport.model.ConsumeShowBean;


@WebServlet("/memberOnly/healthRecord.do")
public class HealthRecordServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession(false); // 取出session物件	
		//確認是否登入
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");  //loginToken
		if (mb == null) {  
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/login.jsp" ));
			return;
		}
		Integer memId = mb.getId();
//		Integer memId = 1;

		//1.接收資料
			String startDay = request.getParameter("startDay");
			String endDay = request.getParameter("endDay");
			String record = request.getParameter("record");
			String chart = request.getParameter("chart");
			//System.out.println("startDay="+startDay+" ,endDay="+endDay+" ,record="+record+" ,chart="+chart);
		//2.驗證資料
		//3.轉換資料
		//4.執行邏輯 、5.導向畫面
			
			if(chart.equals("history")){  //歷史紀錄
				System.out.println("history");
				if(record.equals("absorb")){  //攝取歷史紀錄
					ShowAbsorbHistoryService service = new ShowAbsorbHistoryService();
					List<AbsorbShowBean> beans = service.show(memId, startDay, endDay);
					//request.setAttribute("absorbShow", beans);
					session.setAttribute("absorbShow", beans);
				}else if(record.equals("consume")){  //消耗歷史紀錄
					ShowConsumeHistoryService service = new ShowConsumeHistoryService();
					List<ConsumeShowBean> beans = service.show(memId, startDay, endDay);
					//request.setAttribute("absorbShow", beans);
					session.setAttribute("consumeShow", beans);
				}
				//request.getRequestDispatcher("/MembersOnly/history.jsp").forward(request, response);
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/MembersOnly/history.jsp"));
				return;
			}else if(chart.equals("line")){  //直條圖
				System.out.println("line");
				if(record.equals("absorb")){  //攝取直條圖	
					response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/MembersOnly/linechart?memId="+memId+"&startDay="+startDay+"&endDay="+endDay+"&type=absorb"));
					return;
				}else if(record.equals("consume")){  //消耗直條圖
					response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/MembersOnly/linechart?memId="+memId+"&startDay="+startDay+"&endDay="+endDay+"&type=consume"));
					return;
				}
			}else if(chart.equals("borkenLine")){  //折線圖
				System.out.println("borkenLine"); 
				if(record.equals("absorb")){  //攝取折線圖
					response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/MembersOnly/borkenline?memId="+memId+"&startDay="+startDay+"&endDay="+endDay+"&type=absorb"));
					return;
				}else if(record.equals("consume")){  //消耗折線圖
					response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/MembersOnly/borkenline?memId="+memId+"&startDay="+startDay+"&endDay="+endDay+"&type=consume"));
					return;
				}
			}
			
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
