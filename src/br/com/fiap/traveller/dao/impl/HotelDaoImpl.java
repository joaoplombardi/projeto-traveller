package br.com.fiap.traveller.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.traveller.dao.HotelDao;
import br.com.fiap.traveller.models.Hotel;

public class HotelDaoImpl extends GenericDaoImpl<Hotel, Integer> implements HotelDao{

	public HotelDaoImpl(EntityManager em) {
		super(em);
	}
	
	@Override
	public List<Hotel> searchForAcceptableDistance(Double distance) {
		return em.createQuery("SELECT h FROM Hotel h WHERE h.avPaulistaDistance < :distance", Hotel.class)
		.setParameter("distance", distance)
		.getResultList();
	}

}
