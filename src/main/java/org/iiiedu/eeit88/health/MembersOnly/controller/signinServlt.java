package org.iiiedu.eeit88.health.MembersOnly.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iiiedu.eeit88.health.MembersOnly.model.signinBean;
import org.iiiedu.eeit88.health.MembersOnly.model.signinService;


@WebServlet("/MembersOnly/signin.do")
public class signinServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private signinService sns = new signinService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");

		int memid = 5;
		int CS = 4;
		
		String prodaction = req.getParameter("action");
		System.out.println(prodaction);

		signinBean bean = new signinBean();
		bean.setMemid(5);
		bean.setSign(true);
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		bean.setLastsignin(stamp);
		bean.setSignintime(stamp);
		bean.setContinuous(CS);
		
		System.out.println(bean);

		Map<String, String> errorMsg = new HashMap<String, String>();
		req.setAttribute("error", errorMsg);

		
		
		
		if ("Insert".equals(prodaction)) {
			signinBean  esult = sns.insert(bean);
			if (esult == null) {
				errorMsg.put("action", "新增資料失敗");
			} else {
				req.setAttribute("insert", esult);
				
			}
			
		}req.getRequestDispatcher("/MembersOnly/signin.jsp").forward(req, response);
//		signinBean beans = new signinBean();
//		List<signinBean> result = sns.select(memid);
//		req.setAttribute("snsAll", result);
//		SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
//		String dateNow = dfDate.format(stamp);
//		System.out.println(dateNow);
//		req.getRequestDispatcher("/MembersOnly/signin.jsp").forward(req, response);
//		return;
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
