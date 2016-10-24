package org.iiiedu.eeit88.health.calories.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.iiiedu.eeit88.health.food.model.AbsorbItemsBean;




public class AbsorbCart {
	private Map<Integer,AbsorbItemsBean> cart = new HashMap<>();
	public Map<Integer,AbsorbItemsBean> getContent(){  //得到一筆紀錄${AbsorbCart.content}
//		System.out.println(cart);
		return cart;
	}
	
	@Override
	public String toString() {
		return "AbsorbCart [cart=" + cart + "]";
	}

	public void addToCart(int foodId,AbsorbItemsBean bean){
		if(cart.get(foodId) == null){  //第一次加入紀錄
			cart.put(foodId, bean);
		} else{  //第二次加入紀錄(數量(oldBean)=新的+舊的)
			AbsorbItemsBean oldBean = cart.get(foodId);
			oldBean.setQuantity(oldBean.getQuantity()+bean.getQuantity());//第二次以上加入紀錄
		}
	}  //end of add
	
	public boolean modifyQty(int foodId,AbsorbItemsBean bean){//??????
		if( cart.get(foodId) != null && bean.getQuantity()>0){
			cart.put(foodId, bean);
			return true;
		}else{
			return false;
		}
	}//end of modify()
	
	public boolean modifyQty(int foodId,int newQty){  //指定數量加入
		if(cart.get(foodId) !=null){
			AbsorbItemsBean bean = (AbsorbItemsBean) cart.get(foodId);
			bean.setQuantity(newQty);
			cart.put(foodId, bean);
			return true;
		} else{
			return false;
		}
	}//end of modifyQty
	
	public void addQty(int foodId,int quantity){  //+
		if(cart.get(foodId) != null){
			AbsorbItemsBean oldBean = cart.get(foodId);
			oldBean.setQuantity(oldBean.getQuantity()+quantity);
		} else{
			
		}
	}
	
	public void decreaseQty(int foodId,int quantity){  //-
		if(cart.get(foodId) != null){
			
			AbsorbItemsBean oldBean = cart.get(foodId);
			oldBean.setQuantity(oldBean.getQuantity()+quantity);
		} else{
			
		}
	}
	
	
	public int delete(int foodId){
		if(cart.get(foodId) != null){
			cart.remove(foodId);
			return 1;
		} else{
			return 0;
		}
	}//end of delete
	
	
	public int getItemNumber(){  // AbsorbCart.itemNumber
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
	
	
	
}//end of class
