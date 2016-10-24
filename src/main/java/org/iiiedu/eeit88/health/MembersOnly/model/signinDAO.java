package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.List;

public interface signinDAO {
	
//	public abstract signinBean select();
	
	public abstract List<signinBean> select(int memid);
	
	public abstract signinBean insert(signinBean bean);
	
	
}
