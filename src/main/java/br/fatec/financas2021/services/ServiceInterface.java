package br.fatec.financas2021.services;

import java.util.List;

public interface ServiceInterface<T> {
	T create(T obj);
	T FindById(Long id);
	List<T> FindAll();
	boolean update(T obj);
	boolean delete(Long id);
}
