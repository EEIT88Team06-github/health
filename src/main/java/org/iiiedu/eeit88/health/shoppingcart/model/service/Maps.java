package org.iiiedu.eeit88.health.shoppingcart.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Maps {
	public static void main(String[] args){
		Map map1 = new HashMap();
		map1.put("1", "aaa");
		map1.put("2", "bbb");
		map1.put("3", "ccc");
		
		Set set1 = map1.keySet();
		Set set2 = map1.entrySet();
		Collection collect1 = map1.values();
		System.out.println("set1=" + set1);
		System.out.println("set2=" + set2);
		System.out.println("collect1="+ collect1);
	}
}
