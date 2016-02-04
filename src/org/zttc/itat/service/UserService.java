package org.zttc.itat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zttc.itat.dao.IGroupDao;
import org.zttc.itat.dao.IUserDao;
import org.zttc.itat.exception.UserException;
import org.zttc.itat.model.Group;
import org.zttc.itat.model.Pager;
import org.zttc.itat.model.User;

@Service("userService")
public class UserService implements IUserService {
	private IUserDao userHibernateDao;
	
	private IGroupDao groupHibernateDao;
	
	

	public IUserDao getUserHibernateDao() {
		return userHibernateDao;
	}

	@Resource
	public void setUserHibernateDao(IUserDao userHibernateDao) {
		this.userHibernateDao = userHibernateDao;
	}

	public IGroupDao getGroupHibernateDao() {
		return groupHibernateDao;
	}
	@Resource
	public void setGroupHibernateDao(IGroupDao groupHibernateDao) {
		this.groupHibernateDao = groupHibernateDao;
	}

	@Override
	public void add(User u, int gid) {
		Group g = groupHibernateDao.load(gid);
		if(g==null) throw new UserException("添加的用户组不存在");
		u.setGroup(g);
		userHibernateDao.add(u);
	}

	@Override
	public void delete(int id) {
		userHibernateDao.delete(id);
	}

	@Override
	public void update(User u,int gid) {
		Group g = groupHibernateDao.load(gid);
		if(g==null) throw new UserException("更新的用户组不存在");
		u.setGroup(g);
		userHibernateDao.update(u);
	}

	@Override
	public User load(int id) {
		return userHibernateDao.load(id);
	}

	@Override
	public List<User> listAllUser() {
		String hql = "from User u left join fetch u.group";
		return userHibernateDao.list(hql);
	}

	@Override
	public List<User> listByGroup(int gid) {
		return userHibernateDao.list("from User where group.id=?", gid);
	}

	@Override
	public Pager<User> findUser() {
		String hql = "from User u left join fetch u.group";
		System.out.println(hql);
		return userHibernateDao.find(hql);
	}

}
