package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.List;

public interface movieDAO {
//	public abstract movieBean select(int memid);
	public abstract List<movieBean> select(int memid);
//	public abstract List<movieBean> select();

}
