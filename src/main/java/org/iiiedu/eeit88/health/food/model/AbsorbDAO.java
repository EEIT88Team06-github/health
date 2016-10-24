package org.iiiedu.eeit88.health.food.model;


import java.util.List;

public interface AbsorbDAO {

	List<AbsorbBean> select();
	
	List<AbsorbBean> select(int memId);
	
	List<AbsorbBean> selectByDate(int memId,String absorbDate);
	
	//select * from absorb where memid=1 and absorbDate between '2016/10/12' and '2016/10/13'
	List<AbsorbBean> selectByDate(int memId, String absorbDateStart, String absorbDateEnd);
	
//	//select id from absorb where memid=1 and absorbDate between '2016/10/12' and '2016/10/13'
//	List<Integer> selectByDate(int memId, String absorbDateStart, String absorbDateEnd);
		
	AbsorbBean selectOne(int id);
	
	AbsorbBean insert(java.util.Date absorbDate,int memId);
	
	AbsorbBean update(java.util.Date absorbDate,int memId,int id);
	
	Boolean delete(int id);

}