package org.iiiedu.eeit88.health.calories.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iiiedu.eeit88.health.bean.MemberBean;
import org.iiiedu.eeit88.health.calories.service.AbsorbCart;
import org.iiiedu.eeit88.health.food.model.AbsorbItemsBean;

@WebServlet("/calculaties/food/addFood.do")
public class AddFood extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession(false); // 取出session物件
		//確認是否登入
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");  //loginToken
		
		if (mb == null) {  
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/login.jsp"));
			return;
		}
		
		
		AbsorbCart cart = (AbsorbCart) session.getAttribute("AbsorbCart");
		if(cart == null){
			cart = new AbsorbCart();
			session.setAttribute("AbsorbCart", cart);
		}
		//System.out.println("cart= "+cart);
		
		String tempFoodId = request.getParameter("foodId");  //System.out.println(tempFoodId);
		String tempQty = request.getParameter("quantity");  //System.out.println(tempQty);
		String tempCalories = request.getParameter("calories");  //System.out.println(tempCalories);
		String foodName = request.getParameter("foodName");  //System.out.println(foodName);
		
		int foodId = 0;
		int quantity = 0;
		float calories = 0 ;
		try{
			foodId = Integer.parseInt(tempFoodId.trim());
			quantity = Integer.parseInt(tempQty.trim());
//				System.out.println(quantity);
			calories = Float.parseFloat(tempCalories.trim());
		}catch(NumberFormatException e){
			System.out.println("資料格式錯誤");
		}
		
		AbsorbItemsBean bean = new AbsorbItemsBean(foodId,quantity,calories,foodName);
		cart.addToCart(foodId,bean);   //System.out.println(bean);

		Collection<AbsorbItemsBean> absorbRecord = cart.getContent().values();
		//System.out.println("absorbRecord= "+absorbRecord);

		Iterator<AbsorbItemsBean> it = absorbRecord.iterator();	//將每一個AbsorbItemsBean取出
		while(it.hasNext()){
			AbsorbItemsBean one = it.next();
			foodId = one.getFoodId();
			foodName = one.getFoodName();
			quantity = one.getQuantity();	
			calories = one.getCalories();
			
			
			String pic = "<img src='"+request.getContextPath()+"/getImage?id="+foodId+"&type=food' "+
					"style='width: 60%;height: 60%'/>";

			
			PrintWriter out = response.getWriter();  //傳回的data
			out.print("<tr><td style='width: 15%'>"+pic+
					  "</td><td style='width: 25%'>"+foodName+
					  "</td><td style='width: 10%'>"+calories+
					  "</td><td style='width: 15%'>"+quantity+
					  "</td><td style='width: 35%'>"+
					  		"<button type='submit' class='btn btn-info qtystatus' value='+' name='modifyStatus' onclick='doclick()' >+</button>  "+									
					  		"<button type='submit' class='btn btn-warning qtystatus' value='-' name='modifyStatus' onclick='doclick()' >-</button>  "+
					  		"<button type='submit' class='btn btn-danger qtystatus' value='x' name='modifyStatus' onclick='doclick()' >x</button>  "+
					  "</td></tr>"
					);

		}//end of while

	}  //end of doGet

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
