package br.com.fiap.traveller.view;

import java.util.List;

import br.com.fiap.traveller.dao.impl.HotelDaoImpl;
import br.com.fiap.traveller.dao.impl.RatingDaoImpl;
import br.com.fiap.traveller.models.Hotel;
import br.com.fiap.traveller.singleton.EntityManagerSingleton;

public class SearchView {
	public static void main(String[] args) {
		
		List<Hotel> hotelsLessThan1KM = 
				new HotelDaoImpl(EntityManagerSingleton.getInstance())
									.searchForAcceptableDistance(5000.0);
		List<Hotel> hotelsLessThan10KM = 
				new HotelDaoImpl(EntityManagerSingleton.getInstance()).
									searchForAcceptableDistance(10000.0);
		
		System.out.println(hotelsLessThan1KM.size());
		System.out.println(hotelsLessThan10KM.size());
		
		List<Hotel> hotelsNameLike = 
				new HotelDaoImpl(EntityManagerSingleton.getInstance())
									.searchByName("IBIS");
		
		System.out.println(hotelsNameLike.size());
		
		System.out.println(
				new RatingDaoImpl(EntityManagerSingleton.getInstance())
									.ratingOfAHotel(16));
		
	}
}
