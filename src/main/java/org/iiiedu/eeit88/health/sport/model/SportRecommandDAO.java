package org.iiiedu.eeit88.health.sport.model;

import java.util.List;

public interface SportRecommandDAO {

	List<SportRecommandBean> select();//end of select all
	
	List<Integer> selectAll(int memId);  //print Integer by all

	SportRecommandBean select(int memId);//end of select by mem_id

	SportRecommandBean insert(java.util.Date sportRecommandDate, int sportId, int memId);//end of insert

}