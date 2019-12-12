package com.example.demo.skuList;

public class Sku {
	private int goodId;
	private String goodName;
	private String price;

	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Sku(int goodId,String goodName,String price) {
		this.goodId = goodId;
		this.goodName = goodName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Result [goodId=" + goodId + ", goodName=" + goodName + ", price=" + price +"]";
	}
}
