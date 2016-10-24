package org.iiiedu.eeit88.health.calories.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.calories.service.AbsorbCart;
import org.iiiedu.eeit88.health.member.model.MemberBean;



@WebServlet("/calculaties/food/modifyQuantity.do")
public class ModifyFoodQtyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession(false);  // 取出session物件
		
//		if(session == null){  //連線逾時
//		response.sendRedirect(request.getContextPath()+"/login.jsp" );
//		return;	
//	}
		
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
//		if(mb==null){  //確認是否登入，沒有要導向login(登入後要導回??)
//			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/login.jsp"));
//			return;
//		}
		
		AbsorbCart ac = (AbsorbCart) session.getAttribute("AbsorbCart");
		if(ac == null){  //如果在攝取紀錄裡找不到要加的，導向首頁
			//request.getRequestDispatcher("/noItems.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/noItems.jsp");
			return;
		}
		
		
		
		//1.接收資料
			String modifyStatus = request.getParameter("modifyStatus");
			String tempFoodId = request.getParameter("foodId");
			//System.out.println("tempFoodId="+tempFoodId);
			String tempQuantity = request.getParameter("quantity");
			//System.out.println("tempQuantity="+tempQuantity);
		//2.驗證資料
		//3.轉換資料
			int foodId = Integer.parseInt(tempFoodId);
			//System.out.println("foodId"+foodId);
			int quantity = Integer.parseInt(tempQuantity);
			
		//4.執行邏輯
			if(modifyStatus.equals("+")){  //加1
				//System.out.println("+");  
				ac.addQty(foodId, 1);
			} else if (modifyStatus.equals("-")){  //減1
				//System.out.println("-");
				if(quantity>1){  //當數量大於1時才可以減
					ac.decreaseQty(foodId, -1);
				}else{  //若數量等於1時，將其刪除
					//System.out.println("delete");
					ac.delete(foodId);
				}
			
			} else if (modifyStatus.equals("x")){
				//System.out.println("x");
				ac.delete(foodId);
			}
		//5.導向畫面
			//request.getRequestDispatcher("/showfood").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/calculaties/food/showfood.do");
			return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
