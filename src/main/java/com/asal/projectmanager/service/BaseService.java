package com.asal.projectmanager.service;

import java.util.List;

public interface BaseService<E> {
	public List<E> getAll(); 
	public void add(E object);
	public void delete(E object);
	public E findOne(Long id);
}
