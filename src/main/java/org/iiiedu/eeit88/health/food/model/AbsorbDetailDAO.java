package org.iiiedu.eeit88.health.food.model;


import java.util.List;

public interface AbsorbDetailDAO {
	
	List<AbsorbDetailBean> select();
	
	List<AbsorbDetailBean> select(int absorbId);
	
	AbsorbDetailBean selectOne(int id);
	
	AbsorbDetailBean insert(int absorbId, int foodId, int quantity,int id);
	
	AbsorbDetailBean update(int foodId, int quantity, int id);
	
	Boolean delete(int id);
}
