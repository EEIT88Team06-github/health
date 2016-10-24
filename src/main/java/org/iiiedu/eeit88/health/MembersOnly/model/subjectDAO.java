package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.List;

public interface subjectDAO {
//	public abstract subjectBean select(int id);
	public abstract List<subjectBean> select(int memid); 
}
