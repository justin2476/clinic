package com.clinic.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Doctor")
public class Doctor {

	@Id
	private long id;
	private String name;
	private String address;
	private String mobile;
	private String[] areaOfExp;

	

	public Doctor(String name, String address, String mobile, String[] areaOfExp) {
		super();
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.areaOfExp = areaOfExp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String[] getAreaOfExp() {
		return areaOfExp;
	}

	public void setAreaOfExp(String[] areaOfExp) {
		this.areaOfExp = areaOfExp;
	}

}
