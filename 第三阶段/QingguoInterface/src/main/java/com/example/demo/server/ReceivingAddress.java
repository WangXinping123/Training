package com.example.demo.server;


/**
 * @author 杨硕 添加地址
 *
 */
public class ReceivingAddress {
	private Object receiverName;
	private Object cellPhone;
	private Object addressDetail;
	private Object province;
	private Object city;
	private Object area;
	public Object getreceiverName() {
		return receiverName;
	}
	public void setreceiverName(Object receiverName) {
		this.receiverName = receiverName;
	}
	public Object getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(Object cellPhone) {
		this.cellPhone = cellPhone;
	}
	public Object getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(Object addressDetail) {
		this.addressDetail = addressDetail;
	}
	public Object getProvince() {
		return province;
	}
	public void setProvince(Object province) {
		this.province = province;
	}
	public Object getCity() {
		return city;
	}
	public void setCity(Object city) {
		this.city = city;
	}
	public Object getArea() {
		return area;
	}
	public void setArea(Object area) {
		this.area = area;
	}
	
	public ReceivingAddress(Object receiverName,Object cellPhone,Object addressDetail,Object province,Object city,Object area) {
		this.receiverName = receiverName;
		this.cellPhone = cellPhone;
		this.addressDetail = addressDetail;
		this.province = province;
		this.city = city;
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "ReceivingAddress [ receiverName=" + receiverName +",cellPhone=" + cellPhone +",addressDetail=" +addressDetail
				+ ",province=" + province +",city="+city+",area="+area+"]";
		
	}
	
}
