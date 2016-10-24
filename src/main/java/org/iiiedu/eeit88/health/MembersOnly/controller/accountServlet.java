package org.iiiedu.eeit88.health.MembersOnly.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
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

import org.iiiedu.eeit88.health.MembersOnly.model.accountBean;
import org.iiiedu.eeit88.health.MembersOnly.model.accountService;

@WebServlet("/MembersOnly/account.do" )
public class accountServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private  accountService as = new accountService();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		accountRequest(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		accountRequest(request,response);
	}
	
	
	
	public void accountRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
//		HttpSession session = request.getSession();
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int id = 21; 
		
//		Object req	 =	request.getAttribute("asimSession");

////		回傳資料
		accountBean ass = as.select(id);
		String ga = ass.getAccount();
		String gl = ass.getLastname();
		String gf = ass.getFirstname();
		String gn = ass.getNickname();
		Date gd = ass.getBirth();
		String gp = ass.getPhone();
		String gc = ass.getCity();
		String gcy = ass.getConunty();
		String gadd = ass.getAddr();
		String gem = ass.getEmail();
//		
//	String gPPT = ass.getPair();// 是否參加配對
		
		request.setAttribute("accountText", ga);// 帳號
		request.setAttribute("lastnameT", gl);// 姓
		request.setAttribute("firstnameT", gf);// 名
		request.setAttribute("nicknameT", gn);// 暱稱
		request.setAttribute("birthT", gd);// 生日
		request.setAttribute("phoneT", gp);// 手機
		request.setAttribute("cityT", gc);// 縣市
		request.setAttribute("countryT", gcy);// 鄉鎮
		request.setAttribute("addrT", gadd);// 地址
		request.setAttribute("emailT", gem);// E-mail
//		request.setAttribute("PairPT", gPPT);// 是否參加配對
		
		
		request.getRequestDispatcher("/MembersOnly/account.jsp");
		
		
		
//		接收修改
		String lname = request.getParameter("lastname");
		String fname = request.getParameter("firstname");
		String nname = request.getParameter("nickname");
		String pe = request.getParameter("phone");
		String em = request.getParameter("email");
		String pic = request.getParameter("picture"); // 頭像
		String cy = request.getParameter("city");
		String coun = request.getParameter("country");
		String adr = request.getParameter("addr");
		
//		String pir = request.getParameter("pair"); //配對
		
		
		
		
		
		
		
		
		
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("error", errorMsg);
		
		
		String lastname = null;
		if (lname != null && lname.trim().length() != 0) {
			try {
				 lastname = lname;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errorMsg.put("lname", "請輸入中文");
			}
		}
		
		String nickname = null;
		if (fname != null && fname.trim().length() != 0) {
			try {
				nickname = nname;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errorMsg.put("fname", "請輸入中文");
			}
		}
		
		String firstname = null;
		if (nname != null && nname.trim().length() != 0) {
			try {
				firstname = fname;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errorMsg.put("fname", "請輸入正確的格式");
			}
		}
		
		String phone = null;
		if (pe != null && pe.trim().length() != 0) {
			try {
				phone = pe;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errorMsg.put("pe", "pe必須是整數");
			}
		}
		
		String email = null;
		if (em != null && em.trim().length() != 0) {
			try {
				email = em;
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errorMsg.put("email", "請輸入正確的格式");
			}
		}
		
		String city = null;
		if (cy != null && cy.trim().length() != 0) {
			try {
				city = cy;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errorMsg.put("city", "請輸入正確的地址");
			}
		}
		
		String country = null;
		if (coun != null && coun.trim().length() != 0) {
			try {
				country = coun;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errorMsg.put("country", "請輸入正確的地址");
			}
		}
		
		String addr = null;
		if (adr != null && adr.trim().length() != 0) {
			try {
				addr = adr;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				errorMsg.put("addr", "請輸入正確的地址");
			}
		}
		
		
		
		String prodaction = request.getParameter("prodaction");
		
//		String pair = null;
//		if (pir != null && pir.trim().length() != 0) {
//			pair=pir;
//		}
		
		
		
		 accountBean bean = new accountBean();
		 bean.setId(id);
		 bean.setLastname(lastname);
		 bean.setFirstname(firstname);
		 bean.setNickname(nickname);
		 bean.setPhone(phone);
		 bean.setCity(city);
		 bean.setConunty(country);
		 bean.setAddr(addr);
		 bean.setEmail(email);
//		 bean.setPair(pair);	
		 
		
//		 request.getSession().setAttribute("asimSession", ass);
		
		 
		 
		 
		 if("1".equals(prodaction)){
			 accountBean result = as.update(bean);
			 System.out.println(result);
			 
			 
				if (result == null) {
					errorMsg.put("action", "修改資料失敗");
					
				} else {
					
					request.setAttribute("update", result);
					
					request.getRequestDispatcher("/MembersOnly/account.jsp")
					.include(request, response);

//					.include(request, response);
					RequestDispatcher dispatcher =
					request.getRequestDispatcher("/MembersOnly/account.jsp");
					dispatcher.include(request, response);
					
//					response.sendRedirect(response.encodeRedirectURL
//							("/MembersOnly/accson.jsp"));
				}
//				response.sendRedirect(response.encodeRedirectURL
//						("/MembersOnly/account.jsp"));
				
//				RequestDispatcher dispatcher = 
//				request.getRequestDispatcher("/MembersOnly/account.View");
//						dispatcher.include(request, response);
		 }
		 
	}

}
