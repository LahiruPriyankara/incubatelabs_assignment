package com.lahiru.controller;

import java.io.File;
import java.io.IOException;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lahiru.dao.CityDao;
import com.lahiru.dao.HotelDao;
import com.lahiru.daoImpl.HotelDaoImpl;
import com.lahiru.dto.City;

@Controller
public class PageController {

	@Autowired
	HotelDao hotelDaoImpl;
	
	@Autowired
	CityDao cityDaoImpl;

	private String saveDirectory = null;
	
	@RequestMapping(value = { "/addHotel" })
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("NewFile");
		return mv;
	}

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("viewHotel");
		mv.addObject("title", "home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = { "/allHotels" })
	public ModelAndView showAllHotels() {
		ModelAndView mv = new ModelAndView("viewHotel");
		mv.addObject("title", "allHotels");
		mv.addObject("allHotels", hotelDaoImpl.getAllHotels());
		mv.addObject("cityInfo", hotelDaoImpl.cityInfo());
		mv.addObject("userClickAllHotels", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("viewHotel");
		mv.addObject("title", "about");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("viewHotel");
		mv.addObject("title", "contact");
		mv.addObject("userClickContact", true);
		return mv;
	}



	@RequestMapping(value = { "/show/{city_id}/hotels/" })
	public ModelAndView giveHotelsInACity(@PathVariable int city_id) {
		ModelAndView mv = new ModelAndView("viewHotel");
		mv.addObject("hotelsInCity", hotelDaoImpl.getSelectedCityHotels(city_id));
		mv.addObject("cityInfo", hotelDaoImpl.cityInfo());
		mv.addObject("city_id", city_id);
		mv.addObject("title", "selectedHotels");
		mv.addObject("userSelectedCity", true);
		return mv;
	}
	
	@RequestMapping(value = { "/show/hotel/{hotel_id}" })
	public ModelAndView giveOneHotelIfno(@PathVariable int hotel_id) {
		ModelAndView mv = new ModelAndView("viewHotel");
		mv.addObject("hotelInfo", hotelDaoImpl.getOneHotelInfo(hotel_id));
		mv.addObject("cityInfo", hotelDaoImpl.cityInfo());
		mv.addObject("title", "selectOneHotel");
		mv.addObject("selectOneHotel", true);
		return mv;
	}
	
	@RequestMapping(value = { "/insert" })
	public ModelAndView insertNewHotel() {
		ModelAndView mv = new ModelAndView("addNewHotel");
		mv.addObject("cityInfo", hotelDaoImpl.cityInfo());
		mv.addObject("title", "insertHotelPage");
		mv.addObject("insertHotelPage", true);
		return mv;
	}

	@RequestMapping(value = { "/insert/add" }, method = RequestMethod.POST)
	public String insertHotel(HttpServletRequest request,@RequestParam String name,@RequestParam String address,@RequestParam int city_code,@RequestParam CommonsMultipartFile file) throws IllegalStateException, IOException {
        if (file != null ) {
        	System.out.println(request.getSession().getServletContext().getRealPath("/"));
        	//String rpath=request.getPathInfo();


            saveDirectory = request.getSession().getServletContext().getRealPath("/")+"assets\\images\\";
                System.out.println("Saving file: " + file.getOriginalFilename());
                 
                if (!file.getOriginalFilename().equals("")) {
                    file.transferTo(new File(saveDirectory + file.getOriginalFilename()));
                }
        }
        hotelDaoImpl.insertHotelInfo(name,address,city_code,file.getOriginalFilename());
        return "redirect:/allHotels";
	}
	
	
	
	
	@RequestMapping(value = { "insert/add/city" }, method = RequestMethod.POST)
	public String insertHotel(@RequestParam String name,@RequestParam int city_code) {
		City c = new City();
		c.setCity_code(city_code);
		c.setCity_name(name);
		cityDaoImpl.addCity(c);
		//mv.addObject("hotelInfo", cityDaoImpl.addCity(c));
		return "redirect:/insert";
	}
	
	
	@RequestMapping(value = {"/search_hotels"}, method = RequestMethod.GET)
	public ModelAndView getSearchdValue(@RequestParam String q,@RequestParam int b){
		ModelAndView mv = new ModelAndView("hotelSearching");
		mv.addObject("allHotels", hotelDaoImpl.getSearchedHotels(q,b));
		return mv;
	}    
	
}
