package org.iiiedu.eeit88.health.shoppingcart.model;

import java.util.List;

public interface IDetailDAO {
	public abstract List<DetailBean> select(String ordNum);
	public abstract Boolean insert(List<DetailBean> beans);
	public abstract Boolean update(DetailBean bean);
	public abstract Boolean delete(DetailBean bean);
	
}
