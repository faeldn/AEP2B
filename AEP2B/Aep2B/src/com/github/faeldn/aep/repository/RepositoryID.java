package com.github.faeldn.aep.repository;

import java.util.List;

public interface RepositoryID <C,D> {
	
	public List<D> all();
	public D one(C crm);
	public void insert(D entity);

}
