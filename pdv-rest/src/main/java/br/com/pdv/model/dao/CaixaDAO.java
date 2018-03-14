package br.com.pdv.model.dao;

import br.com.pdv.dto.CaixaDTO;
import br.com.pdv.enumerated.StatusCaixaEnum;
import org.springframework.stereotype.Repository;

import br.com.pdv.model.entity.Caixa;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class CaixaDAO extends GenericDAO<Caixa> {

	public CaixaDAO() {
		super(Caixa.class);
	}

	public boolean existeCaixaAberto(Long clienteId) {
		try {
		    em.createQuery("SELECT c from Caixa c INNER JOIN c.usuario u where c.statusCaixa = :statusCaixa and u.id = :clienteId")
					.setParameter("statusCaixa", StatusCaixaEnum.ABERTO)
					.setParameter("clienteId", clienteId).getSingleResult();
			return false;
		} catch (NoResultException e) {
			return true;
		}
	}
}