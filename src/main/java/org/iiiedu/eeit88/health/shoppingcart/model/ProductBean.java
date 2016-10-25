package org.iiiedu.eeit88.health.shoppingcart.model;

import java.io.Serializable;
import java.util.Arrays;

public class ProductBean implements Serializable{

	private Integer id;
	private String name;
	private byte[] pic;
	private Integer price;
	private Integer productType;
	private String content;
	private Integer quantity;
	private Integer total;
	private Boolean productStatus;
	private Integer vendorId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Boolean getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Boolean productStatus) {
		this.productStatus = productStatus;
	}
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", name=" + name + ", pic=" + Arrays.toString(pic) + ", price=" + price
				+ ", productType=" + productType + ", content=" + content + ", quantity=" + quantity + ", total="
				+ total + ", productStatus=" + productStatus + ", vendorId=" + vendorId + "]";
	}
}
