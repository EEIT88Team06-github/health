package org.iiiedu.eeit88.health.shoppingcart.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.bean.MemberBean;
import org.iiiedu.eeit88.health.shoppingcart.model.ContactsBean;
import org.iiiedu.eeit88.health.shoppingcart.model.service.ContactsService;

/**
 * Servlet implementation class ContactsServlet
 */
@WebServlet("/shopping/Contacts")
public class ContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContactsService service = null;
	HttpSession session = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		session = request.getSession();
		MemberBean mBean = (MemberBean) session.getAttribute("LoginOK");
		String intend = request.getParameter("intend");

		
		if(intend.equals(new String("selectAll"))){
			service = new ContactsService();
			List<ContactsBean> beans = service.selectAll(mBean.getId());
			session.setAttribute("contacts", beans);
			RequestDispatcher rd = request.getRequestDispatcher("/shopping/contacts.jsp");
			rd.forward(request, response);
			return;
		}else if(intend.equals(new String("change"))){
//			ContactsService service = new ContactsService();
			String change = request.getParameter("action");
			if(change.equals(new String("寄送給..."))){
				System.out.println(request.getParameter("id"));
				ContactsBean bean = service.selectOne(Integer.parseInt(request.getParameter("id")));
				System.out.println(bean);
				session.setAttribute("contact", bean);
				RequestDispatcher rd = request.getRequestDispatcher("/shopping/shipping.jsp");
				rd.forward(request, response);
				return;
			}else if(change.equals(new String("修改"))){
				
			}else if(change.equals(new String("刪除"))){
				
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/shopping/contacts.jsp");
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
