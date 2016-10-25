package org.iiiedu.eeit88.health.shoppingcart.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.shoppingcart.model.ProductBean;
import org.iiiedu.eeit88.health.shoppingcart.model.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/shopping/Products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String intend = request.getParameter("intend").trim();
		if(intend.equalsIgnoreCase("selectAll")){
			
			ProductService service = new ProductService(); 
			List<ProductBean> beans = new ArrayList<ProductBean>();
			beans = service.selectAll();
			request.setAttribute("allProduct", beans);
			RequestDispatcher rd = request.getRequestDispatcher("/shopping/allProduct.jsp");
			rd.forward(request, response);
			return;
		} else if(intend.equalsIgnoreCase("selectOne")){
			String id = request.getParameter("id").trim();
			ProductService service = new ProductService(); 
			ProductBean bean = service.selectOne(Integer.parseInt(id));
			request.setAttribute("one", bean);
			RequestDispatcher rd = request.getRequestDispatcher("/shopping/product.jsp");
			rd.forward(request, response);
			return;
		} else if(intend.equalsIgnoreCase("selectPic")){
			String id = request.getParameter("id").trim();
			ProductService service = new ProductService();
			byte[] imgData = service.selectPic(Integer.parseInt(id));
			response.setContentType("image/jpeg");
		       OutputStream o = response.getOutputStream();
		       o.write(imgData); 
		       o.flush(); 
		       o.close(); 
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
