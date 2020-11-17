package com.github.faeldn.aep.repository;

import java.util.List;

public interface RepositoryI <K,T>{
	
	public List<T> all();
	public T one(K cpf);
	public void insert(T entity);
	public void delete(K cpf);	
	
	
}
