package org.iiiedu.eeit88.health.shoppingcart.model;

import java.util.List;

public interface IProductTypeDAO {
	public abstract List<ProductTypeBean> select();
	public abstract Boolean insert(String ProdType);
	public abstract Boolean update(ProductTypeBean bean);
	public abstract Boolean hide(Integer id);
}
