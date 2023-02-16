package com.fundsbank.dto;

public class Address {
	private int flatNo;
	private String street;
	private String locality;
	private int pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int flatNo, String street, String locality, int pincode) {
		super();
		this.flatNo = flatNo;
		this.street = street;
		this.locality = locality;
		this.pincode = pincode;
	}
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [flatNo=" + flatNo + ", street=" + street + ", locality=" + locality + ", pincode=" + pincode
				+ "]";
	}
	
	
	
	

}
