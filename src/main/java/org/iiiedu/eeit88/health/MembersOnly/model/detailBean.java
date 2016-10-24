package org.iiiedu.eeit88.health.MembersOnly.model;

public class detailBean {
	
	private Integer id;
	private Integer ordid;
	private Integer prodid;
	private Integer quantiy;
	private Integer total;
	
	
	@Override
	public String toString() {
		return "detailBean [id=" + id + ", ordid=" + ordid + ", prodid=" + prodid + ", quantiy=" + quantiy
				+ ", total=" + total + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrdid() {
		return ordid;
	}
	public void setOrdid(Integer ordid) {
		this.ordid = ordid;
	}
	public Integer getProdid() {
		return prodid;
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	public Integer getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(Integer quantiy) {
		this.quantiy = quantiy;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
