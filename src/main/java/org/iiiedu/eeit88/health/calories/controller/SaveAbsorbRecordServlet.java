package org.iiiedu.eeit88.health.calories.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.bean.MemberBean;
import org.iiiedu.eeit88.health.calories.service.AbsorbCart;
import org.iiiedu.eeit88.health.food.model.AbsorbBean;
import org.iiiedu.eeit88.health.food.model.AbsorbDetailBean;
import org.iiiedu.eeit88.health.food.model.AbsorbItemsBean;
import org.iiiedu.eeit88.health.food.model.dao.AbsorbRecordDAOJdbc;



@WebServlet("/calculaties/food/saverecord.do")
public class SaveAbsorbRecordServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
				
		HttpSession session = request.getSession(false); // 取出session物件
		
		if(session == null){  //連線逾時
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return;	
		}
		
//		//確認是否登入
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");  //loginToken
		
		if (mb == null) {  
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/login.jsp"));
			return;
		}
		
		AbsorbCart ac = (AbsorbCart) session.getAttribute("AbsorbCart");
		if(ac == null){  //如果在攝取紀錄裡找不到要加的，導向首頁
			//request.getRequestDispatcher("/noItems.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/testPage/noItems.jsp" );
			return;
		}
		
		
		//1.接收資料
		String recordStatus = request.getParameter("saveOrCancle");
		//2.驗證資料
		//3.轉換資料
		//4.執行邏輯
		if(recordStatus.equals("保存")){
			//System.out.println("save");
//			int memId = mb.getId();
			int memId = 1;
			java.util.Date absorbDate = new java.util.Date();
			List<AbsorbDetailBean> beans = new ArrayList<AbsorbDetailBean>();
			Map<Integer,AbsorbItemsBean> cart = ac.getContent();
			Set<Integer> set = cart.keySet();
			for(Integer k : set){
				AbsorbItemsBean bean = cart.get(k);
				//System.out.println("AbsorbItemsBean="+bean);
				AbsorbDetailBean detailBeans = new AbsorbDetailBean(0,0,bean.getFoodId(),bean.getQuantity());
				//System.out.println(detailBeans);
				beans.add(detailBeans);
			}
			AbsorbBean absorbBean = new AbsorbBean(absorbDate,memId,beans);
			AbsorbRecordDAOJdbc record = new AbsorbRecordDAOJdbc();
			record.insert(absorbBean);
			session.removeAttribute("AbsorbCart");
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/testPage/insert.jsp"));
		}else if(recordStatus.equals("清除")){
			System.out.println("cancle");
			session.removeAttribute("AbsorbCart");
			request.getRequestDispatcher("/calculaties/testconnection.jsp").forward(request, response);
			return;	
		}
		//5.導向畫面
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
