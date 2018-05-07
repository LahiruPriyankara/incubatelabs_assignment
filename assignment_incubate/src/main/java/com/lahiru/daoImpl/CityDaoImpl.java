package com.lahiru.daoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.lahiru.dao.CityDao;
import com.lahiru.dto.City;

@Repository("cityDaoImpl")
public class CityDaoImpl implements CityDao{

	@Override
	public void addCity(City c) {

		Session session = HotelDaoImpl.sessionBulder();
		Transaction tx = session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
