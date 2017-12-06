package br.com.pdv.model.dao;

import org.springframework.stereotype.Repository;

import br.com.pdv.model.entity.Sangria;

@Repository
public class SangriaDAO extends GenericDAO<Sangria> {

	public SangriaDAO() {
		super(Sangria.class);
	}
}