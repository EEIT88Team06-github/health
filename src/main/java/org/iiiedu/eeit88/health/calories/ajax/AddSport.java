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

import org.iiiedu.eeit88.health.bean.MemberBean;
import org.iiiedu.eeit88.health.calories.service.ConsumeCart;
import org.iiiedu.eeit88.health.sport.model.ConsumeItemsBean;


@WebServlet("/calculaties/sport/addSport.do")
public class AddSport extends HttpServlet{

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
		
		
		ConsumeCart cart = (ConsumeCart) session.getAttribute("ConsumeCart");
		if(cart == null){
			cart = new ConsumeCart();
			session.setAttribute("ConsumeCart", cart);
		}
		//System.out.println("cart= "+cart);
		
		String tempSportId = request.getParameter("sportId");  //System.out.println(tempSportId);
		String tempQty = request.getParameter("quantity");  //System.out.println(tempQty);
		String tempCalories = request.getParameter("calories");  //System.out.println(tempCalories);
		String sportName = request.getParameter("sportName");  //System.out.println(sportName);
		
		int sportId = 0;
		int quantity = 0;
		float calories = 0 ;
		try{
			sportId = Integer.parseInt(tempSportId.trim());
			quantity = Integer.parseInt(tempQty.trim());
//				System.out.println(quantity);
			calories = Float.parseFloat(tempCalories.trim());
		}catch(NumberFormatException e){
			System.out.println("資料格式錯誤");
		}
		
		ConsumeItemsBean bean = new ConsumeItemsBean(sportId,quantity,calories,sportName);
		cart.addToCart(sportId,bean);   //System.out.println(bean);
		
		Collection<ConsumeItemsBean> sportRecord = cart.getContent().values();
		//System.out.println("sportRecord= "+sportRecord);

		Iterator<ConsumeItemsBean> it = sportRecord.iterator();	//將每一個ConsumeItemsBean取出
		while(it.hasNext()){
			ConsumeItemsBean one = it.next();
			sportId = one.getSportId();
			sportName = one.getSportName();
			quantity = one.getQuantity();	
			calories = one.getCalories();
			
			
			String pic = "<img src='"+request.getContextPath()+"/getImage?id="+sportId+"&type=sport' "+
					"style='width: 20px;height: 20px'/>";

			
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

	}  //end of doGet

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
