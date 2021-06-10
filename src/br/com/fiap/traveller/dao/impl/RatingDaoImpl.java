package br.com.fiap.traveller.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.traveller.dao.RatingDao;
import br.com.fiap.traveller.exception.EntityNotFoundException;
import br.com.fiap.traveller.models.Hotel;
import br.com.fiap.traveller.models.Rating;

public class RatingDaoImpl extends GenericDaoImpl<Rating, Integer> implements RatingDao {
	public RatingDaoImpl(EntityManager em) {
		super(em);
	}

	@Override
	public Double ratingOfAHotel(int id) {
		Hotel hotel = new Hotel();
		try {
			hotel = new HotelDaoImpl(em).read(id);			
		}catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		TypedQuery<Double> query = em.createQuery("select r.value from Rating r where r.hotel = :id", Double.class);
		query.setParameter("id", hotel);
		List<Double> allRatings = query.getResultList();
		Double soma = .0; 
		for(Double rating : allRatings) {
			soma += rating;
		}
		return soma/allRatings.size();
	}
}
