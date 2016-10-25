package org.iiiedu.eeit88.health.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.bean.MemberBean;
import org.iiiedu.eeit88.health.service.LoginService;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginService loginService;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		// 將errorMsgMap放入request物件內，識別字串為 "ErrorMsgKey"
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		// 1. 讀取使用者輸入資料
		String userId = request.getParameter("userId");
		String password = request.getParameter("pswd");
		String checkCode = request.getParameter("checkCode");
		String compareCheckCode = request.getSession().getAttribute("randomString") == null ? "" :(String) request.getSession().getAttribute("randomString");
		if (userId == null || userId.trim().length() == 0) {
			errorMsgMap.put("AccountEmptyError", "帳號欄必須輸入");
		}
		// 如果 password 欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if (password == null || password.trim().length() == 0) {
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}
		//檢核驗證碼
		if(checkCode== null || !compareCheckCode.equals(checkCode) ){
			if(!"111".equals(checkCode)){//方便登入,開發者只需輸入111,則驗證碼可過
				errorMsgMap.put("CheckCodeEmptyError", "驗證碼錯誤或未輸入");
			}
		}
		
		// 帳號或密碼未填回 login.jsp
		if (!errorMsgMap.isEmpty()) {
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		
		//檢查密碼是否正確(連DB)
		loginService = new LoginService();
		Map checkAccMap = loginService.checkLogin(userId, password);
		if(checkAccMap.containsKey("checkAccountErrMsg")){
			if(checkAccMap.containsKey("checkAccountType")&& "0".equals(checkAccMap.get("checkAccountType"))){//查無帳號
				errorMsgMap.put("AccountEmptyError", (String) checkAccMap.get("checkAccountErrMsg"));
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;
			}else{//密碼錯誤
				errorMsgMap.put("PasswordEmptyError", (String) checkAccMap.get("checkAccountErrMsg"));
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;
			}
			
		}else{
			// OK, 將mb物件放入Session範圍內，識別字串為"LoginOK"
			session.setAttribute("LoginOK", checkAccMap.get("checkMember"));
			MemberBean member = (MemberBean) checkAccMap.get("checkMember");
			//導回index;
			// 如果errorMsgMap不是空的，表示有錯誤，交棒給login.jsp
			System.out.println("登入者帳號:>>>>>>>"+member.getAccount());
			System.out.println("登入者密碼:>>>>>>>"+member.getPasswords());
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
