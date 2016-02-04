package org.zttc.itat.dao;

import java.util.List;

import org.zttc.itat.model.Pager;

public interface IBaseDao<T> {
	public void add(T t);
	public void delete(int id);
	public void update(T t);
	public T load(int id);
	public List<T> list(String hql, Object[] args);
	public List<T> list(String hql);
	public List<T> list(String hql, Object arg);
	
	public Pager<T> find(String hql, Object[] args);
	public Pager<T> find(String hql, Object arg);
	public Pager<T> find(String hql);
}
