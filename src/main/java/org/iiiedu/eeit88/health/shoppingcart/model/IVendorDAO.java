package org.iiiedu.eeit88.health.shoppingcart.model;

import java.util.List;

public interface IVendorDAO {
	public abstract VendorBean select(int id);
	public abstract List<VendorBean> select();
	public abstract Boolean insert(VendorBean bean);
	public abstract Boolean update(VendorBean bean);
}
