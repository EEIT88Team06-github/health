package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.List;

public interface logpicDAO {
	
	public abstract logpicBean select(int id);

	public abstract List<logpicBean> select();

}
