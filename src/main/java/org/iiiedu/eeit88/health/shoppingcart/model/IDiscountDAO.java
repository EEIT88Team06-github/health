package org.iiiedu.eeit88.health.shoppingcart.model;

import java.sql.Timestamp;
import java.util.List;

public interface IDiscountDAO {
	public abstract List<DiscountBean> selectManage();
	public abstract List<DiscountBean> selectFront(Timestamp ts);	
	public abstract DiscountBean selectOne(Integer prodType, Timestamp ts);
	public abstract DiscountBean select(Integer prodType);
	public abstract Boolean insert(DiscountBean bean);
	public abstract Boolean update(DiscountBean bean);
	public abstract Boolean delete(DiscountBean bean);
}
