package br.com.pdv.model.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable> {

	T findOne(final long id);

	List<T> findAll();

	void create(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final long entityId);
}