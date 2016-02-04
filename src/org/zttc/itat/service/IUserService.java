package org.zttc.itat.service;

import java.util.List;

import org.zttc.itat.model.Pager;
import org.zttc.itat.model.User;

public interface IUserService {
	public void add(User u, int gid);
	
	public void delete(int id);
	
	public void update(User u, int gid);
	
	public User load(int id);
	
	public List<User> listAllUser();
	
	public List<User> listByGroup(int gid);
	
	public Pager<User> findUser();
}
