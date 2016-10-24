package org.iiiedu.eeit88.health.shoppingcart.model.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.iiiedu.eeit88.health.global.MemberBean;
import org.iiiedu.eeit88.health.shoppingcart.model.ContactsBean;
import org.iiiedu.eeit88.health.shoppingcart.model.DetailBean;
import org.iiiedu.eeit88.health.shoppingcart.model.IDetailDAO;
import org.iiiedu.eeit88.health.shoppingcart.model.IOrderItemDAO;
import org.iiiedu.eeit88.health.shoppingcart.model.OrderItemBean;
import org.iiiedu.eeit88.health.shoppingcart.model.ProductBean;
import org.iiiedu.eeit88.health.shoppingcart.model.dao.DetailDAODS;
import org.iiiedu.eeit88.health.shoppingcart.model.dao.OrderItemDAODS;

public class OrderService {

	//設定購物車中選購物品的prodId以及與之對應的ProdBean
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
	
	public Boolean orderFinish(MemberBean mBean, String ordNum, List<DetailBean> beans, ContactsBean cBean) {
		IOrderItemDAO oDao = new OrderItemDAODS();
		IDetailDAO dDao = new DetailDAODS();
		OrderItemBean oBean = new OrderItemBean();
		oBean.setOrdNum(ordNum);
		oBean.setMemId(mBean.getId());
		long now = System.currentTimeMillis();
		long fiveDaysLater = now + 1000*60*60*24*5;
		Timestamp ts = new Timestamp(now);
		oBean.setOrdTime(ts);
		oBean.setBonus(mBean.getBonus());
		ts = new Timestamp(fiveDaysLater);
		oBean.setShipTime(ts);
		oBean.setShipStatus(1);
		if(cBean == null){
			oBean.setPhone(mBean.getPhone());
			oBean.setName(mBean.getLastname()+mBean.getFirstname());
			oBean.setOrderItemAddress(mBean.getCity()+mBean.getCountry()+mBean.getAddr());
		}else {
			oBean.setPhone(cBean.getPhone());
			oBean.setName(cBean.getName());
			oBean.setOrderItemAddress(cBean.getContactAddress());
		}
		System.out.println(oBean);
		Boolean result = oDao.insert(oBean);
		Boolean result2 = dDao.insert(beans);
			
		if(result == true && result2 == true)
			return true;
		else
			return false;
	}
}
