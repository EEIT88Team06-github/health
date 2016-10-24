package org.iiiedu.eeit88.health.shoppingcart.model.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.iiiedu.eeit88.health.shoppingcart.model.DetailBean;
import org.iiiedu.eeit88.health.shoppingcart.model.DiscountBean;
import org.iiiedu.eeit88.health.shoppingcart.model.IDiscountDAO;
import org.iiiedu.eeit88.health.shoppingcart.model.IProductDAO;
import org.iiiedu.eeit88.health.shoppingcart.model.ProductBean;
import org.iiiedu.eeit88.health.shoppingcart.model.dao.DiscountDAODS;
import org.iiiedu.eeit88.health.shoppingcart.model.dao.ProductDAODS;

public class ProductService {
	private IProductDAO productDao;
	private IDiscountDAO discountDao;
	
	
	public List<ProductBean> selectAll() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		productDao = new ProductDAODS();
		discountDao = new DiscountDAODS();
		Map<Integer, ProductBean> map = new HashMap<Integer, ProductBean>();
		List<ProductBean> productBeans = productDao.selectFront();
		List<DiscountBean> DiscountBeans = discountDao.selectFront(ts);
		
		Iterator<ProductBean> productIt = productBeans.iterator();
		Iterator<DiscountBean> discountIt = DiscountBeans.iterator();
		
		while(discountIt.hasNext()){
			DiscountBean discountBean = (DiscountBean)discountIt.next();
			while(productIt.hasNext()){
				ProductBean productBean = (ProductBean)productIt.next();
				if(productBean.getProductType() == discountBean.getProdType()){
					int price = productBean.getPrice();
					float discount = discountBean.getDiscount();
					price = (int)( price * discount);
					productBean.setPrice(price);
				}
			}
		}
		return productBeans;
	}
	
	public ProductBean selectOne(int id) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		productDao = new ProductDAODS();
		discountDao = new DiscountDAODS();
		ProductBean productBean = productDao.select(id);
		DiscountBean discountBean = discountDao.selectOne(productBean.getProductType(), ts);
		if(discountBean != null){
			int price = productBean.getPrice();
			float discount = discountBean.getDiscount();
			price = (int)( price * discount);
			productBean.setPrice(price);
		}
			
		return productBean;
	}
	
	public byte[] selectPic(int id){
		productDao = new ProductDAODS();
		byte[] b = productDao.selectPic(id);
		return b;
	}
	
	

}
