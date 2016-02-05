package org.zttc.itat.service;

import org.springframework.stereotype.Service;
import org.zttc.itat.dao.IGroupDao;
import org.zttc.itat.dao.IUserDao;
import org.zttc.itat.exception.UserException;
import org.zttc.itat.model.Group;

import javax.annotation.Resource;
import java.util.List;

@Service("groupService")
public class GroupService implements IGroupService {
	private IGroupDao groupHibernateDao;
	private IUserDao userHibernateDao;
	
	

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
	public void add(Group group) {
		groupHibernateDao.add(group);
	}

	@Override
	public void delete(int id) {
		long count = userHibernateDao.getGroupUserCount(id);
		if(count>0) throw new UserException("删除的组还有用户");
		//userHibernateDao.deleteByGroup(id);
		//如果在这个位置抛出异常
//		if(id>0) throw new UserException();
		groupHibernateDao.delete(id);
	}

	@Override
	public void update(Group group) {
		groupHibernateDao.update(group);
	}

	@Override
	public Group load(int id) {
		return groupHibernateDao.load(id);
	}

	@Override
	public List<Group> listAllGroup() {
		return groupHibernateDao.list("from Group");
	}

}
