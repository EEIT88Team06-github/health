package org.iiiedu.eeit88.health.shoppingcart.model;

import java.util.List;

public interface IOrderItemDAO {
	public abstract List<OrderItemBean> select(int memId);
	public abstract List<OrderItemBean> select();
	public abstract Boolean insert(OrderItemBean bean);
	public abstract Boolean update(OrderItemBean bean);
	public abstract Boolean delete(OrderItemBean bean);
}
