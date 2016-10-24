package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.List;

public interface slimminglogDAO {
	
	public abstract slimminglogBean select(int id);
	
	public abstract List<slimminglogBean> select();

	public abstract slimminglogBean insert(slimminglogBean bean);

	public abstract slimminglogBean update(
			Integer id, java.util.Date date, String content, Boolean share
			);

	public abstract boolean delete(Integer id);
	
}
