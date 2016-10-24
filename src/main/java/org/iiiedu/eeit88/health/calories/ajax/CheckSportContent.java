package org.iiiedu.eeit88.health.calories.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.calories.service.ConsumeCart;
import org.iiiedu.eeit88.health.sport.model.ConsumeItemsBean;




@WebServlet("/calculaties/sport/checkSport.do")
public class CheckSportContent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession(false); // 取出session物件
		//確認是否登入
//		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");  //loginToken
//		
//		if (mb == null) {  
//			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/index.jsp"));
//			return;
//		}
		
		ConsumeCart cart = (ConsumeCart) session.getAttribute("ConsumeCart");
		if(cart == null){
			cart = new ConsumeCart();
			session.setAttribute("Consume", cart);
		}
		
		
		Collection<ConsumeItemsBean> consumeRecord = cart.getContent().values();
		
		Iterator<ConsumeItemsBean> it = consumeRecord.iterator();	//將每一個ConsumeItemsBean取出
		while(it.hasNext()){
			ConsumeItemsBean one = it.next();
			int sportId = one.getSportId();
			String sportName = one.getSportName();
			int quantity = one.getQuantity();	
			float calories = one.getCalories();
			
			
			String pic = "<img src='"+request.getContextPath()+"/getImage?id="+sportId+"&type=sport' "+
					"style='width: 60%;height: 60%'/>";

			
			PrintWriter out = response.getWriter();  //傳回的data
			out.print("<tr><td style='width: 15%'>"+pic+
					  "</td><td style='width: 25%'>"+sportName+
					  "</td><td style='width: 10%'>"+calories+
					  "</td><td style='width: 15%'>"+quantity+
					  "</td><td style='width: 35%'>"+
					  		"<button type='submit' class='btn btn-info qtystatus' value='+' name='modifyStatus'>+</button>  "+									
					  		"<button type='submit' class='btn btn-warning qtystatus' value='-' name='modifyStatus'>-</button>  "+
					  		"<button type='submit' class='btn btn-danger qtystatus' value='x' name='modifyStatus'>x</button>  "+
					  "</td></tr>"
					);

		}//end of while
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
