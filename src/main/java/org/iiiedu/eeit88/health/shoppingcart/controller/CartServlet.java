package org.iiiedu.eeit88.health.shoppingcart.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import org.iiiedu.eeit88.health.shoppingcart.model.DetailBean;
import org.iiiedu.eeit88.health.shoppingcart.model.ProductBean;
import org.iiiedu.eeit88.health.shoppingcart.model.service.CartService;
import org.iiiedu.eeit88.health.shoppingcart.model.service.OrderService;

@WebServlet("/shopping/Cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		if (session.getAttribute("LoginOK") == null) {
			String requestURI = request.getRequestURI();
			String path = request.getPathInfo();
			response.sendRedirect("/health/login.jsp");
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/login.jsp");
			// rd.forward(request, response);
			return;
		}
		// String intend = request.getParameter("intend").trim();
		Integer orderTotal = 0;
		session.setAttribute("orderTotal", orderTotal);
		MemberBean mBean = (MemberBean) session.getAttribute("LoginOK");
		String memId = String.valueOf(mBean.getId());
		String ordNum = request.getParameter("ordNum");
		String type = request.getParameter("type").trim();
		System.out.println(type);
		String prodId = request.getParameter("prodId").trim();
		String number = request.getParameter("number").trim();
		// String button = request.getParameter("check").trim();
		if (type.equals(new String("修改")))
			type = "update";
		else if (type.equals(new String("刪除")))
			type = "delete";
		

		if (type.equalsIgnoreCase("add")) {
			if (ordNum == "") { // 如果ordNum為空，表示為此session新增之購物清單
				System.out.println(1);
				CartService cs = new CartService();
				List<DetailBean> beans = new ArrayList<DetailBean>();
				beans = cs.add(beans, ordNum, Integer.parseInt(memId), Integer.parseInt(prodId),
						Integer.parseInt(number));
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				Iterator it = beans.iterator();
				while (it.hasNext()) {
					DetailBean bean = (DetailBean) it.next();
					map.put(bean.getProdId(), bean.getQuantity());
					orderTotal = bean.getTotal() + orderTotal;
				}
				String ordNumber = beans.iterator().next().getOrdNum();
				session.setAttribute("orderTotal", orderTotal);
				session.setAttribute("ordNum", ordNumber);
				session.setAttribute("quantityMap", map);
				session.setAttribute("cartBeans", beans); // 將新產生的detail內容塞進cartBean的session物件
			} else if (ordNum.equals(session.getAttribute("ordNum"))) { // 不為空，代表已經有cartBean物件存在
				System.out.println(2);
				CartService cs = new CartService();
				Map<Integer, Integer> map = (HashMap) session.getAttribute("quantityMap");
				List<DetailBean> beans = (List<DetailBean>) session.getAttribute("cartBeans");
				beans = cs.add(beans, ordNum, Integer.parseInt(memId), Integer.parseInt(prodId),
						Integer.parseInt(number));
				Iterator it = beans.iterator();
				while (it.hasNext()) {
					DetailBean bean = (DetailBean) it.next();
					map.put(bean.getProdId(), bean.getQuantity());
					orderTotal = bean.getTotal() + orderTotal;
				}
				session.setAttribute("cartBeans", beans); // 將新加入的detail內容塞進cartBean的session物件
				session.setAttribute("quantityMap", map);
				session.setAttribute("orderTotal", orderTotal);
			}
			String path = request.getHeader("referer");
			System.out.println(path);
			response.sendRedirect(path);
			return;
		} else if (type.equalsIgnoreCase("check")) {
			session = request.getSession();
			CartService service = new CartService();
			Map<Integer, ProductBean> map = new HashMap<Integer, ProductBean>();
			map = service.selectOrder((List<DetailBean>) session.getAttribute("cartBeans"));
			request.setAttribute("orderProduct", map);
			RequestDispatcher rd = request.getRequestDispatcher("/shopping/cart.jsp");
			rd.forward(request, response);
			return;
		} else if (type.equalsIgnoreCase("update")) {
			CartService cs = new CartService();
			Map<Integer, Integer> map = (HashMap) session.getAttribute("quantityMap");
			List<DetailBean> beans = (List<DetailBean>) session.getAttribute("cartBeans");
			beans = cs.update(beans, Integer.parseInt(memId), Integer.parseInt(prodId), Integer.parseInt(number));
			Iterator it = beans.iterator();
			
			while (it.hasNext()) {
				DetailBean bean = (DetailBean) it.next();
				map.put(bean.getProdId(), bean.getQuantity());
				orderTotal = bean.getTotal()+orderTotal;
			}
			session.setAttribute("cartBeans", beans); // 將新加入的detail內容塞進cartBean的session物件
			session.setAttribute("quantityMap", map);
			session.setAttribute("orderTotal", orderTotal);
			RequestDispatcher rd = request.getRequestDispatcher("/shopping/cart.jsp");
			rd.forward(request, response);
			return;

		} else if (type.equalsIgnoreCase("delete")) {
			CartService cs = new CartService();
			Map<Integer, Integer> map = (HashMap) session.getAttribute("quantityMap");
			List<DetailBean> beans = (List<DetailBean>) session.getAttribute("cartBeans");
			beans = cs.delete(beans, Integer.parseInt(memId), Integer.parseInt(prodId));
			System.out.println(beans);
			if (beans == null) {
				session.removeAttribute("ordNum");
				response.sendRedirect("/health/shopping/Products?intend=selectAll");
//				RequestDispatcher rd = request.getRequestDispatcher("/shopping/Products?intend=selectAll");
//				rd.forward(request, response);
				return;
			} else {
				Iterator it = beans.iterator();
				while (it.hasNext()) {
					DetailBean bean = (DetailBean) it.next();
					map.put(bean.getProdId(), bean.getQuantity());
					orderTotal = bean.getTotal() + orderTotal;
				}
			}
			session.setAttribute("cartBeans", beans); // 將新加入的detail內容塞進cartBean的session物件
			session.setAttribute("quantityMap", map);
			session.setAttribute("orderTotal", orderTotal);
			RequestDispatcher rd = request.getRequestDispatcher("/shopping/cart.jsp");
			rd.forward(request, response);
			return;
		} else {
			String path = request.getHeader("referer");
			System.out.println(path);
			response.sendRedirect(path);
		}
		// String path =
		// request.getRequestURI().substring(request.getContextPath().length());
		// request.getHeader(HttpHeaders.REFERER)

		// RequestDispatcher rd = request.getRequestDispatcher(path);
		// rd.forward(request, response);
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
