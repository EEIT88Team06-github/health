package org.iiiedu.eeit88.health.sport.model;

import java.util.List;

public interface ConsumeDetailDAO {
	List<ConsumeDetailBean> select();
	
	List<ConsumeDetailBean> select(int consumeId);
	
	ConsumeDetailBean selectOne(int id);
	
	ConsumeDetailBean insert(int consumeId,int sportId,int quantity,int id);
	
	ConsumeDetailBean update(int sportId,int quantity,int id);
	
	Boolean delete(int id);
}
