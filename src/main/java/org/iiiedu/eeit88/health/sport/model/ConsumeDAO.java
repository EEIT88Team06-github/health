package org.iiiedu.eeit88.health.sport.model;

import java.util.List;

public interface ConsumeDAO {
	
	List<ConsumeBean> select();
	
	List<ConsumeBean> select(int memId);
	
	List<ConsumeBean> selectByDate(int memId,String consumeDate);
	
	List<ConsumeBean> selectByDate(int memId,String consumeDateStart,String consumeDateEnd);
	
	ConsumeBean selectOne(int id);
	
	ConsumeBean insert(java.util.Date consumeDate,int memId);
	
	ConsumeBean update(java.util.Date consumeDate,int memId,int id);
	
	Boolean delete(int id);
}
