package org.zttc.itat.dao;


import org.springframework.stereotype.Repository;
import org.zttc.itat.model.User;

@Repository("userHibernateDao")
public class UserHibernateDao extends BaseDao<User> implements IUserDao {

	@Override
	public long getGroupUserCount(int gid) {
		String hql = "select count(*) from User where group.id=?";
		long count = (Long)this.getSession().createQuery(hql)
					.setParameter(0, gid).uniqueResult();
		return count;
	}

	@Override
	public void deleteByGroup(int gid) {
		String hql = "delete User u where u.group.id=?";
		this.getSession().createQuery(hql).setParameter(0, gid).executeUpdate();
	}


}
