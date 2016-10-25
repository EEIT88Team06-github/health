package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.List;

public interface collsubDAO {
	
	public abstract List<collsubBean> select(int memid);
	
	public abstract boolean delete(int id);
}
