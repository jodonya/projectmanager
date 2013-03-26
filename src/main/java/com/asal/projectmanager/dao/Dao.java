package com.asal.projectmanager.dao;

import java.util.List;

public interface Dao<E> {
	public List<E> getAll(); 
	public void add(E object);
	public Boolean delete(E object);
	public E getById(Integer id);
}
