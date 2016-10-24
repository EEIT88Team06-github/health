package org.iiiedu.eeit88.health.food.model;

import java.util.List;

public interface CookRecommandDAO {

	List<CookRecommandBean> select();//print all
	
	List<Integer> selectAll(int memId); //print Integer by all
	
	CookRecommandBean select(int memId);//end of select by mem_id

	CookRecommandBean insert(java.util.Date cookRecommandDate, int cookId, int memId);//end of insert

}