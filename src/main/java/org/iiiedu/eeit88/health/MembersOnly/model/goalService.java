package org.iiiedu.eeit88.health.MembersOnly.model;

import org.iiiedu.eeit88.health.MembersOnly.model.dao.goalDAODS;
import org.iiiedu.eeit88.health.MembersOnly.model.dao.slimminglogDAODS;

public class goalService {
	private goalDAO Dao = new goalDAODS();

	public goalBean select(int goal) {
		goalBean result = Dao.select(goal);
		return result;
	}
	
	public goalBean update(goalBean bean) {
		goalBean result = null;
		if(bean!=null) {
			result = Dao.update(bean.getGoal(),bean.getContent(),bean.getGoaltime(),null);
		}
		return result;
	}
}
