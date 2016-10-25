package org.iiiedu.eeit88.health.calories.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.iiiedu.eeit88.health.calories.service.ConsumeCart;
import org.iiiedu.eeit88.health.sport.model.ConsumeBean;
import org.iiiedu.eeit88.health.sport.model.ConsumeDetailBean;
import org.iiiedu.eeit88.health.sport.model.ConsumeItemsBean;
import org.iiiedu.eeit88.health.sport.model.ConsumeRecordDAO;
import org.iiiedu.eeit88.health.sport.model.dao.ConsumeRecordDAOJdbc;

@WebServlet("/calculaties/sport/saverecord.do")
public class SaveConsumeRecordServlet extends HttpServlet {

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
		
		ConsumeCart cc = (ConsumeCart) session.getAttribute("ConsumeCart");
		if(cc == null){  //如果在消耗紀錄裡找不到要加的，導向
			response.sendRedirect(request.getContextPath() + "/testPage/noItems.jsp" );
			return;
		}
		
		
		//1.接收資料
		String recordStatus = request.getParameter("saveOrCancle");
		//2.驗證資料
		//3.轉換資料
		//4.執行邏輯
		if(recordStatus.equals("保存")){
			int memId = mb.getId();
//			int memId = 1;
			java.util.Date consumeDate = new java.util.Date();
			List<ConsumeDetailBean> beans = new ArrayList<ConsumeDetailBean>();
			Map<Integer,ConsumeItemsBean> cart = cc.getContent();
			Set<Integer> set = cart.keySet();
			for(Integer k : set){
				ConsumeItemsBean bean = cart.get(k);
				ConsumeDetailBean detailBeans = new ConsumeDetailBean(0,0,bean.getSportId(),bean.getQuantity());
				beans.add(detailBeans);
			}
			ConsumeBean consumeBean = new ConsumeBean(consumeDate,memId,beans);
			ConsumeRecordDAO record = new ConsumeRecordDAOJdbc();
			record.insert(consumeBean);
			session.removeAttribute("ConsumeCart");
		//5.導向畫面
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/testPage/insert.jsp"));
			return;
		}else if(recordStatus.equals("清除")){
			System.out.println("cancle");
			session.removeAttribute("ConsumeCart");
		//5.導向畫面
			request.getRequestDispatcher("/calculaties/testconnection.jsp").forward(request, response);
			return;	
		}
		
	}//end of doGet

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
