package com.lahiru.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class City {

	@Id
	private int code;
	private String city_name;
	

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public int getCity_code() {
		return code;
	}

	public void setCity_code(int city_code) {
		this.code = city_code;
	}

	@Override
	public String toString() {
		return "City [code=" + code + ", city_name=" + city_name + "]";
	}

	
	
}
	