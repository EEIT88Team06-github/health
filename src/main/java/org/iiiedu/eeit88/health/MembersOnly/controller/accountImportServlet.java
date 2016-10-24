package org.iiiedu.eeit88.health.MembersOnly.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.MembersOnly.model.accountBean;
import org.iiiedu.eeit88.health.MembersOnly.model.accountService;

/**
 * Servlet implementation class accountImportServlet
 */
@WebServlet(urlPatterns = { "/MembersOnly/account.view" })

public class accountImportServlet extends HttpServlet {
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
		
		
		HttpSession session = request.getSession();
	
		response.setHeader("content-type","text/html;charset=UTF-8");
		request.setCharacterEncoding("ISO-8859-1");
		
		int id = 2;

//		回傳資料
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
		String gPPT = ass.getPair();// 是否參加配對
		
//		String aee = ass.getAddr();
//		request.getSession().setAttribute("asimSession", ass);
		
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
		request.setAttribute("PairPT", gPPT);// 是否參加配對
		
	
		
//		request.getSession().setAttribute("asimSession", ass);
		request.setAttribute("asimSession",ass);
//		response.sendRedirect("/health/MembersOnly/account.jsp");
		
		request.getRequestDispatcher("/MembersOnly/account.jsp")
		.include(request, response);
		return;
		 
	}
}
