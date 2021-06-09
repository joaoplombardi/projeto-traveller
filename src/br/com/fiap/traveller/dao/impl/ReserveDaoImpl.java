package br.com.fiap.traveller.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.traveller.dao.ReserveDao;
import br.com.fiap.traveller.models.Reserve;

public class ReserveDaoImpl extends GenericDaoImpl<Reserve, Integer> implements ReserveDao {
	public ReserveDaoImpl(EntityManager em) {
		super(em);
	}
}
