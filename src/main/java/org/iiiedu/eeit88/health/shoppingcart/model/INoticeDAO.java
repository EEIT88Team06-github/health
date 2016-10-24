package org.iiiedu.eeit88.health.shoppingcart.model;

import java.util.List;

public interface INoticeDAO {

	public abstract List<NoticeBean> select(int memId);
	public abstract Boolean insert(NoticeBean bean);
	//public abstract DiscountBean update(DiscountBean bean);
	//trigger
	public abstract Boolean delete(NoticeBean bean);
}
