package org.iiiedu.eeit88.health.MembersOnly.model;

public interface goalDAO {
	public abstract goalBean select(int goal);
	public abstract goalBean update(
			 Integer goal,
			 Float content,
			 java.util.Date goaltime,
			 Integer memid
			);
}
