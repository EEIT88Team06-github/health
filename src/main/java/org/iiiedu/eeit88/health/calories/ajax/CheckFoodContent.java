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

import org.iiiedu.eeit88.health.calories.service.AbsorbCart;
import org.iiiedu.eeit88.health.food.model.AbsorbItemsBean;


@WebServlet("/calculaties/food/checkFood.do")
public class CheckFoodContent extends HttpServlet{

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
		
		AbsorbCart cart = (AbsorbCart) session.getAttribute("AbsorbCart");
		if(cart == null){
			cart = new AbsorbCart();
			session.setAttribute("AbsorbCart", cart);
		}
		
		
		Collection<AbsorbItemsBean> absorbRecord = cart.getContent().values();
		
		Iterator<AbsorbItemsBean> it = absorbRecord.iterator();	//將每一個AbsorbItemsBean取出
		while(it.hasNext()){
			AbsorbItemsBean one = it.next();
			int foodId = one.getFoodId();
			String foodName = one.getFoodName();
			int quantity = one.getQuantity();	
			float calories = one.getCalories();
			
			
			String pic = "<img src='"+request.getContextPath()+"/getImage?id="+foodId+"&type=food' "+
					"style='width: 60%;height: 60%'/>";

			
			PrintWriter out = response.getWriter();  //傳回的data
			out.print("<tr><td style='width: 15%'>"+pic+
					  "</td><td style='width: 25%'>"+foodName+
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
