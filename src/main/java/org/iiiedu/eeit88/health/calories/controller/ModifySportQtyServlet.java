package org.iiiedu.eeit88.health.calories.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.bean.MemberBean;
import org.iiiedu.eeit88.health.calories.service.ConsumeCart;

@WebServlet("/calculaties/sport/modifyQuantity.do")
public class ModifySportQtyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession(false);  // 取出session物件
		
		if(session == null){  //連線逾時
		response.sendRedirect(request.getContextPath()+"/login.jsp" );
		return;	
	}
		
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		if(mb==null){  //確認是否登入，沒有要導向login(登入後要導回??)
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/login.jsp"));
			return;
		}
		
		ConsumeCart cc = (ConsumeCart) session.getAttribute("ConsumeCart");
		if(cc == null){  //如果在攝取紀錄裡找不到要加的，導向
			response.sendRedirect(request.getContextPath()+"/noItems.jsp");
			return;
		}
		
		
		
		//1.接收資料
			String modifyStatus = request.getParameter("modifyStatus");
			String tempSportId = request.getParameter("sportId");
			String tempQuantity = request.getParameter("quantity");
		//2.驗證資料
		//3.轉換資料
			int sportId = Integer.parseInt(tempSportId);
			int quantity = Integer.parseInt(tempQuantity);
			
		//4.執行邏輯
			if(modifyStatus.equals("+")){  //加1 
				cc.addQty(sportId, 1);
			} else if (modifyStatus.equals("-")){  //減1
				if(quantity>1){  //當數量大於1時才可以減
					cc.decreaseQty(sportId, -1);
				}else{  //若數量等於1時，將其刪除
					cc.delete(sportId);
				}
			} else if (modifyStatus.equals("x")){
				cc.delete(sportId);
			}
		//5.導向畫面
			response.sendRedirect(request.getContextPath()+"/calculaties/sport/showsport.do");
			return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
