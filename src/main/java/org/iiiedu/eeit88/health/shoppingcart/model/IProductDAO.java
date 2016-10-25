package org.iiiedu.eeit88.health.shoppingcart.model;

import java.util.List;

public interface IProductDAO {
	public abstract ProductBean select(int id);
	public abstract List<ProductBean> selectFront();
	public abstract List<ProductBean> selectManage();
	public abstract byte[] selectPic(int id);	
	public abstract Boolean insert(ProductBean bean);
	public abstract Boolean update(ProductBean bean);
	public abstract Boolean show(int id);
	public abstract Boolean hide(int id);
}
