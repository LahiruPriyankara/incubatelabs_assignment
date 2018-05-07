package com.lahiru.dao;

import java.util.List;

import com.lahiru.dto.City;
import com.lahiru.dto.Hotels;

public interface HotelDao {

	public List getCityNames();
	public List<City> cityInfo();
	public List<City> getAllHotels();
	public List<City> getSearchedHotels(String q,int b);
	public List<City> getSelectedCityHotels(int city_code);
	public Hotels getOneHotelInfo(int hotel_id);
	public String insertHotelInfo(String name, String address, int city_code,String Image_name);

}
