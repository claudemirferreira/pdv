package br.com.pdv.model.dao;

import br.com.pdv.dto.CaixaDTO;
import br.com.pdv.enumerated.StatusCaixaEnum;
import org.springframework.stereotype.Repository;

import br.com.pdv.model.entity.Caixa;

import javax.persistence.NoResultException;

@Repository
public class CaixaDAO extends GenericDAO<Caixa> {

	public CaixaDAO() {
		super(Caixa.class);
	}

	public boolean existeCaixaAberto(CaixaDTO dto) {
		try {
			em.createQuery("SELECT u from Caixa u where u.statusCaixa = :statusCaixa")
					.setParameter("statusCaixa", StatusCaixaEnum.ABERTO).getSingleResult();
			return false;
		} catch (NoResultException e) {
			return true;
		}
	}
}