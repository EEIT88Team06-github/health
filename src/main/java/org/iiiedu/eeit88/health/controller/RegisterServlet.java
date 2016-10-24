package org.iiiedu.eeit88.health.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.iiiedu.eeit88.health.DbUtils.GmailSendMailviaTLS;
import org.iiiedu.eeit88.health.bean.MemberBean;
import org.iiiedu.eeit88.health.dao.RegisterDao;
import org.iiiedu.eeit88.health.global.GlobalService;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
		* 1024 * 500 * 5)
@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
		session.setAttribute("MsgOK", msgOK); // 顯示正常訊息
		String fileName = "";

		String password = "";
		String lastname = "";
		String firstname = "";
		String gender = "";
		String nickname = "";
		String birth = "";
		String addr = "";
		String bonus = "";
		String phone = "";
		String height = "";
		String weights = "";
		String email = "";
		String city = "";
		String county = "";
		String pair = "";
		String account = "";
		String password2 = "";
		// email及照片未加
		String inter = "";

		int experience = 0;
		long sizeInBytes = 0;
		InputStream is = null;
		Collection<Part> parts = request.getParts(); // 取出HTTP multipart
														// request內所有的parts
		GlobalService.exploreParts(parts, request);
		if (parts != null) { // 如果這是一個上傳資料的表單

			// 2. 進行必要的資料轉換
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				if (p.getContentType() == null) {
					if (fldName.equals("account")) {
						account = value;
					}else if (fldName.equals("gender")) {
						gender = value;
					} else if (fldName.equals("password")) {
						password = value;
					} else if (fldName.equals("password2")) {
						password2 = value;
					} else if (fldName.equals("firstname")) {
						firstname = value;
					} else if (fldName.equals("lastname")) {
						lastname = value;
					} else if (fldName.equals("nickname")) {
						nickname = value;
					} else if (fldName.equals("birth")) {
						birth = value;
					} else if (fldName.equals("phone")) {
						phone = value;
					} else if (fldName.equals("addr")) {
						addr = value;
					} else if (fldName.equals("city")) {
						city = value;
					} else if (fldName.equals("county")) {
						county = value;
					} else if (fldName.equals("email")) {
						email = value;
					} else if (fldName.equals("height")) {
						height = value;
					} else if (fldName.equals("weights")) {
						weights = value;
					} else if (fldName.startsWith("inter")) {
						if (!"".equals(inter)) {
							inter += "," + value;
						} else {
							inter += "" + value;
						}

					}
				} else {
					fileName = GlobalService.getFileName(p); // 此為圖片檔的檔名
					fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
					if (fileName != null && fileName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					} else {
						errorMsg.put("errPicture", "必須挑選圖片檔");
					}

				}
			}

			// 3. 檢查使用者輸入資料
			// if (account == null || account.trim().length() == 0) {
			// errorMsg.put("errorIDEmpty", "帳號欄必須輸入");
			// }
			// if (password == null || password.trim().length() == 0) {
			// errorMsg.put("errorPasswordEmpty", "密碼欄必須輸入");
			// }
			// if (password2 == null || password2.trim().length() == 0) {
			// errorMsg.put("errorPassword2Empty", "密碼確認欄必須輸入");
			// }
			// if (password.trim().length() > 0 && password2.trim().length() >
			// 0) {
			// if (!password.trim().equals(password2.trim())) {
			// errorMsg.put("errorPassword2Empty", "密碼欄必須與確認欄一致");
			// errorMsg.put("errorPasswordEmpty", "*");
			// }
			// }
			// if (firstname == null || firstname.trim().length() == 0) {
			// errorMsg.put("errorfirstname", "名字欄必須輸入");
			// }
			// if (lastname == null || lastname.trim().length() == 0) {
			// errorMsg.put("errorlastname", "姓氏欄必須輸入");
			// }
			// if (addr == null || addr.trim().length() == 0) {
			// errorMsg.put("errorAddr", "地址欄必須輸入");
			// }
			// if (email == null || email.trim().length() == 0) {
			// errorMsg.put("errorEmail", "電子郵件欄必須輸入");
			// }

			// 如果有錯誤
			if (!errorMsg.isEmpty()) {
				// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
				return;
			}

			try {
				// 4. 進行Business Logic運算
				// RegisterServiceFile類別的功能：
				// 1.檢查帳號是否已經存在
				// 2.儲存會員的資料
				RegisterDao rs = new RegisterDao();
				if (rs.idExists(account)) {
					errorMsg.put("errorIDDup", "此帳號已存在，請換新帳號");
				} else {
					MemberBean mBean = new MemberBean();
					mBean.setLastname(lastname);
					mBean.setFirstname(firstname);
					mBean.setGender(gender);
					//日期轉換
					if(!"".equals(birth)){
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						Date birthDate = formatter.parse(birth);
						mBean.setBirth(new java.sql.Date(birthDate.getTime()));
					}
					
					mBean.setAddr(addr);
					mBean.setBonus(100);// 註冊送100點
					mBean.setPhone(phone);
					if (height != null && !"".equals(height)) {
						//身高轉換 float 取兩位數
						BigDecimal b = new BigDecimal(Float.valueOf(height)); 
						float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue(); 
						
						mBean.setHeight(f1);
					}
					if (weights != null && !"".equals(weights)) {
						//體重轉換 float 取兩位數
						BigDecimal b = new BigDecimal(Float.valueOf(weights)); 
						float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue(); 
						mBean.setWeights(Float.valueOf(f1));
					}
					mBean.setEmail(email);
					mBean.setCity(city);
					mBean.setCounty(county);
					mBean.setPair("true".equals(pair));
					mBean.setAccount(account);
					mBean.setPasswords(password);
					mBean.setNickName(nickname);

					// DB 儲存,將MemberBean mem立即寫入Database
					System.out.println("filename:" + fileName);
					int n = rs.saveMember(mBean,is,sizeInBytes);
					
					
					if (n == 1) {
						//寄發認證信
						String content = "親愛的 用戶"+mBean.getNickName()+"\n";
						content+="請點選下列網址，確認註冊成功\n";
						content+="http://localhost:8080/health/registerFinish.jsp";
						System.out.println("寄送emailReady.");
						GmailSendMailviaTLS.sendEmail(email, "Health網站認證信", content);
						msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
						response.sendRedirect("registerEmail.jsp");
						return;
					} else {
						errorMsg.put("errorIDDup", "新增此筆資料有誤(RegisterServlet)");
					}
				}
				// 5.依照 Business Logic 運算結果來挑選適當的畫面
				if (!errorMsg.isEmpty()) {
					// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.forward(request, response);
					return;
				}else{
					// 導向寄信頁面訊息
					RequestDispatcher rd = request.getRequestDispatcher("registerEmail.jsp");
					rd.forward(request, response);
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
				errorMsg.put("errorIDDup", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}

		}

	}

}
