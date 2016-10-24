package org.iiiedu.eeit88.health.shoppingcart.model;

import java.util.List;

public interface IFollowDAO {
	public abstract List<FollowBean> select(int memId);
	public abstract Boolean insert(FollowBean bean);
	//public abstract FollowBean update(FollowBean bean);
	public abstract Boolean delete(FollowBean bean);
}
