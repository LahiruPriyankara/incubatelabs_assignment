package com.lahiru.daoImpl;

import com.lahiru.dao.HotelDao;
import com.lahiru.dto.City;
import com.lahiru.dto.Hotels;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

@Repository("hotelDaoImpl")
public class HotelDaoImpl implements HotelDao{

	public static Session sessionBulder(){
		Configuration con = new Configuration().configure().addAnnotatedClass(City.class).addAnnotatedClass(Hotels.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		return session;
	}
	

@Override
public List getCityNames(){
	Session session = HotelDaoImpl.sessionBulder();
	SQLQuery Squery = session.createSQLQuery("select * from city");
	List<Object[]> nm = (List<Object[]>) Squery.list();
	List<City> city = new ArrayList<City>();
	City c ;
	
	for (Object[] ct : nm){
		c = new City();
		c.setCity_code((Integer)ct[0]);
		c.setCity_name((String)ct[1]);
		city.add(c);
	}
	
	return city;
}


@Override
public List<City> cityInfo(){
	Session session = HotelDaoImpl.sessionBulder();
	Query query = session.createQuery("from City");
	List list = query.list();
	return list;
}
@Override
public List<City> getAllHotels(){
	Session session = HotelDaoImpl.sessionBulder();
	Query query = session.createQuery("from Hotels");
	List list = query.list();
	return list;
}


@Override
public List<City> getSelectedCityHotels(int city_code){
	Session session = HotelDaoImpl.sessionBulder();
	Query query = session.createQuery("from Hotels where city_code = ?");
	query.setParameter(0, city_code);
	List list = query.list();
	return list;
}
@Override
public Hotels getOneHotelInfo(int hotel_id){
	Session session = HotelDaoImpl.sessionBulder();
	Query query = session.createQuery("from Hotels where hotel_id = ?");
	query.setParameter(0, hotel_id);
	Hotels ht = (Hotels) query.uniqueResult();
	return ht;
}

@Override
public String insertHotelInfo(String name, String address, int city_code,String Image_name){
	Session session = HotelDaoImpl.sessionBulder();
	
	Hotels ht = new Hotels();
	ht.setHotel_address(address);
	ht.setHotel_name(name);
	ht.setCity_code(city_code);
	ht.setImage_name(Image_name);
	
	Transaction tx = session.beginTransaction();
	session.save(ht);
	
	session.getTransaction().commit();
	session.close();
	
	return "Successfully Added";
}



@Override
public List<City> getSearchedHotels(String q,int b) {
	Session session = HotelDaoImpl.sessionBulder();
	Query query=null;
	if(b==0 && q==null){
		query = session.createQuery("from Hotels");
	}
	else if(b==0){
		query = session.createQuery("from Hotels where hotel_name like ?");
		query.setParameter(0, "%"+q+"%");
	}
	else if(q==null){
		query = session.createQuery("from Hotels where city_code = ?");
		query.setParameter(0, b);
	}
	else{
		query = session.createQuery("from Hotels where city_code = ? and hotel_name like ?");
		query.setParameter(0, b);
		query.setParameter(1, "%"+q+"%");
	}
	List list = query.list();
	return list;
}

}
