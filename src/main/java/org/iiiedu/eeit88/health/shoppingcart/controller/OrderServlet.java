package org.iiiedu.eeit88.health.shoppingcart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.global.MemberBean;
import org.iiiedu.eeit88.health.shoppingcart.model.ContactsBean;
import org.iiiedu.eeit88.health.shoppingcart.model.DetailBean;
import org.iiiedu.eeit88.health.shoppingcart.model.ProductBean;
import org.iiiedu.eeit88.health.shoppingcart.model.service.CartService;
import org.iiiedu.eeit88.health.shoppingcart.model.service.OrderService;
import org.iiiedu.eeit88.health.shoppingcart.model.service.ProductService;

/**
 * Servlet implementation class Order
 */
@WebServlet("/shopping/Order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String intend = request.getParameter("intend");
		
		
		String path = request.getHeader("referer");
		System.out.println("39" + path);
		String URI = request.getRequestURI();
		System.out.println("41" + URI);
		System.out.println("42" +session.getAttribute("ordNum"));
		if(session.getAttribute("ordNum") == null){
			response.sendRedirect("/health");
//			RequestDispatcher rd = request.getRequestDispatcher("/shopping/Products?intend=selectAll");
//			rd.forward(request, response);
			return;
		}
		
		if(intend.equalsIgnoreCase("check")){
			System.out.println(1);
			session = request.getSession();
			CartService service = new CartService(); 
			Map<Integer, ProductBean> map = new HashMap<Integer, ProductBean>();
			map = service.selectOrder((List<DetailBean>)session.getAttribute("cartBeans"));
			session.setAttribute("orderProduct", map);
			RequestDispatcher rd = request.getRequestDispatcher("/shopping/cart.jsp");
			rd.forward(request, response);
			return;
		}else if(intend.equalsIgnoreCase("orderConfirm")){
			System.out.println(2);
			MemberBean mBean = (MemberBean) session.getAttribute("LoginOK");
			String type = "";
			String button = request.getParameter("orderSubmit");
			if(button.equals(new String("貨到付款")))
				type = "home";
			else if(button.equals(new String("超商取貨")))
				type = "convinent";
			else if(button.equals(new String("匯款轉帳")))
				type = "wired";
			else if(button.equals(new String("信用卡付款")))
				type = "credit";
			
			if(type == "home"){
				String bonus = request.getParameter("bonus");
				//網頁回傳數字型態為Long
				Integer orderTotal = (int)((long)session.getAttribute("finalTotal"));
				System.out.println("71" +orderTotal);
				
				RequestDispatcher rd = request.getRequestDispatcher("/shopping/shipping.jsp");
				rd.forward(request, response);
				return;
				
			}else if(type == "convinent"){
				
			}else if(type == "wired"){
				
			}else if(type == "credit"){
				
			}else{
				System.out.println(3);
				RequestDispatcher rd = request.getRequestDispatcher("/shopping/cart.jsp");
				rd.forward(request, response);
				return;
			}
		}else if(intend.equalsIgnoreCase("finish")){
			MemberBean mBean = (MemberBean) session.getAttribute("LoginOK");
			String ordNum = (String) session.getAttribute("ordNum");
			List<DetailBean> beans = (List<DetailBean>) session.getAttribute("cartBeans");
			OrderService service = new OrderService();
			ContactsBean cBean = (ContactsBean) session.getAttribute("contact");
//			System.out.println("94"+cBean);
//			System.out.println("95" +ordNum);
//			System.out.println("96" +beans);
			Boolean b = service.orderFinish(mBean, ordNum, beans, cBean);
			System.out.println("97" + b);
			request.setAttribute("ordNum", ordNum);
			session.removeAttribute("ordNum");
			session.removeAttribute("cartBeans");
			session.removeAttribute("quantityMap");
			session.removeAttribute("orderTotal");
			session.removeAttribute("contacts");
			session.removeAttribute("contact");
			
//			response.sendRedirect("/health/shopping/orderFinish.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/shopping/orderFinish.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
