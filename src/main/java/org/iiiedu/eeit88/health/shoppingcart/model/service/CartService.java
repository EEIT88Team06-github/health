package org.iiiedu.eeit88.health.shoppingcart.model.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.iiiedu.eeit88.health.shoppingcart.model.DetailBean;
import org.iiiedu.eeit88.health.shoppingcart.model.ProductBean;

public class CartService {
	private DetailBean bean = null;
	
	
	public List<DetailBean> add(List<DetailBean> beans, String ordNum,int memId, int prodId, int number){
		if(ordNum == ""){
			Calendar c = Calendar.getInstance();
			String year = String.valueOf(c.get(Calendar.YEAR));
			String month = String.valueOf(c.get(Calendar.MONTH)+1);
			String date = String.valueOf(c.get(Calendar.DATE));
			String hour = String.valueOf(c.get(Calendar.HOUR));
			String minute = String.valueOf(c.get(Calendar.MINUTE));
			String second = String.valueOf(c.get(Calendar.SECOND));
			
			int r = (int)(Math.random()*9+1);
			String orderNumber = year + month + date + hour + minute + second +String.valueOf(memId) + r;
			ProductService productService = new ProductService();
			ProductBean productBean = productService.selectOne(prodId);
			int total = productBean.getPrice() * number;
			bean = new DetailBean();
			bean.setOrdNum(orderNumber);
			bean.setProdId(prodId);
			bean.setQuantity(number);
			bean.setTotal(total);
			bean.setProdName(productBean.getName());
			System.out.println(bean);
			beans.add(bean);
			
		}else{
			Iterator it = beans.iterator();
			DetailBean bean = null;
			while(it.hasNext()){
				bean = (DetailBean) it.next();
				if( prodId == bean.getProdId()){
					bean.setQuantity(number);
					ProductService productService = new ProductService();
					ProductBean productBean = productService.selectOne(prodId);
					int total = productBean.getPrice() * bean.getQuantity();
					bean.setTotal(total);
					return beans;
				}
					
			}
			
			bean = new DetailBean();
			ProductService productService = new ProductService();
			ProductBean productBean = productService.selectOne(prodId);
			int total = productBean.getPrice() * number;
			bean.setOrdNum(ordNum);
			bean.setProdId(prodId);
			bean.setQuantity(number);
			bean.setTotal(total);
			bean.setProdName(productBean.getName());
			beans.add(bean);
		}
		return beans;
	}

	public List<DetailBean> update(List<DetailBean> beans,int memId, int prodId, int number){
		Iterator it = beans.iterator();
		DetailBean bean = null;
		while(it.hasNext()){
			bean = (DetailBean) it.next();
			if( prodId == bean.getProdId()){
				bean.setQuantity(number);
				ProductService productService = new ProductService();
				ProductBean productBean = productService.selectOne(prodId);
				int total = productBean.getPrice() * bean.getQuantity();
				bean.setTotal(total);
				System.out.println(bean);
			}
		}
		return beans;
	}
	
	public List<DetailBean> delete(List<DetailBean> beans,int memId, int prodId){
		Iterator it = beans.iterator();
		DetailBean bean = null;
		while(it.hasNext()){
			bean = (DetailBean) it.next();
			if( prodId == bean.getProdId()){
				it.remove(); //不要使用collect或list本身remove方法，容易出現exception
							 //使用iterator的remove方法
			}
		}
		if(beans.iterator().hasNext()){
			return beans;
		}else{
			beans = null;
			return beans;
		}
	}
	
	public Map<Integer, ProductBean> selectOrder(List<DetailBean> beans){
		Map<Integer, ProductBean> map = new HashMap<Integer, ProductBean>();
		DetailBean detailBean = null;
		ProductBean productBean = null;
		ProductService ps = new ProductService();
		Iterator it = beans.iterator();
		while(it.hasNext()){
			detailBean = (DetailBean) it.next();
			productBean = new ProductBean();
			productBean = ps.selectOne(detailBean.getProdId());
			map.put(productBean.getId(), productBean);
		}
		
		return map;
	}
}
