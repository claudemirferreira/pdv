package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.AbstractEntityDTO;

public interface IService<T extends AbstractEntityDTO> {
    
    public List<T> findAll();

    public T save(T dto);

    public T update(T dto);

    public T findId(Long id);

    public void delete(Long id);

}