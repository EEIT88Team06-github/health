package org.iiiedu.eeit88.health.MembersOnly.model;

import java.util.List;

public interface detailDAO  {

	public abstract detailBean select(int id);
	public abstract List<detailBean> select(); 
	public abstract boolean delete(int id);
}
