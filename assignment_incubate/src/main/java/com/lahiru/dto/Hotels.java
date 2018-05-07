package com.lahiru.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Hotels {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    //auto increment field
	private int hotel_id;
	private String hotel_name;
	private String hotel_address;
	private String image_name;
	private int city_code;
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_address() {
		return hotel_address;
	}
	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public int getCity_code() {
		return city_code;
	}
	public void setCity_code(int city_code) {
		this.city_code = city_code;
	}
	@Override
	public String toString() {
		return "Hotels [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_address=" + hotel_address
				+ ", image_name=" + image_name + ", city_code=" + city_code + "]";
	}
	
	
	
		
}
