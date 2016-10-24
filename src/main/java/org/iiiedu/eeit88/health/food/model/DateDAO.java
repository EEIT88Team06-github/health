package org.iiiedu.eeit88.health.food.model;

import java.util.List;

public interface DateDAO {
	List<DateBean> select();
	DateBean select(String date);
	List<DateBean> select(String startDay,String endDay);
}
