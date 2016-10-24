package org.iiiedu.eeit88.health.calories.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.iiiedu.eeit88.health.sport.model.ConsumeItemsBean;

public class ConsumeCart {
	private Map<Integer,ConsumeItemsBean> cart = new HashMap<>();
	
	public Map<Integer,ConsumeItemsBean> getContent(){  //得到一筆紀錄${ConsumeCart.content}
		return cart;
	}
	
	public void addToCart(int sportId,ConsumeItemsBean bean){
		if(cart.get(sportId) == null){  //第一次加入紀錄
			cart.put(sportId, bean);
		} else{
			ConsumeItemsBean oldBean = cart.get(sportId);
			oldBean.setQuantity(oldBean.getQuantity()+bean.getQuantity());//第二次加入紀錄
		}
	}//end of add
	
	public boolean modifyQty(int sportId,ConsumeItemsBean bean){
		if( cart.get(sportId) != null && bean.getQuantity()>0){
			cart.put(sportId, bean);
			return true;
		}else{
			return false;
		}
	}//end of modify
	
	public boolean modifyQty(int sportId,int newQty){  //指定數量加入
		if(cart.get(sportId) !=null){
			ConsumeItemsBean bean = (ConsumeItemsBean) cart.get(sportId);
			bean.setQuantity(newQty);
			cart.put(sportId, bean);
			return true;
		} else{
			return false;
		}
	}//end of modifyQty
	
	public void addQty(int sportId,int quantity){  //+
		if(cart.get(sportId) != null){
			ConsumeItemsBean oldBean = cart.get(sportId);
			oldBean.setQuantity(oldBean.getQuantity()+quantity);
		} 
	}//end of addQty
	
	public void decreaseQty(int sportId,int quantity){  //-
		if(cart.get(sportId) != null){
			ConsumeItemsBean oldBean = cart.get(sportId);
			oldBean.setQuantity(oldBean.getQuantity()+quantity);
		} 
	}//end of decreaseQty
	
	public int delete(int sportId){
		if(cart.get(sportId) != null){
			cart.remove(sportId);
			return 1;  //true
		} else{
			return 0;  //false
		}
	}//end of delete
	
	public int getItemNumber(){  // ConsumeCart.itemNumber
		return cart.size();
	}
	
	public float getTotal(){  //計算熱量總攝取量
		float total = 0;
		
		Set<Integer> set = cart.keySet();
		for(int n : set){
			float calories = cart.get(n).getCalories();
			int quantity = cart.get(n).getQuantity();
			total = total+calories*quantity;
		}	
		return total;
	}//end of getTotal
}
