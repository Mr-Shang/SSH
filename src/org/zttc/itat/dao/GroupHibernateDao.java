package org.zttc.itat.dao;

import org.springframework.stereotype.Repository;
import org.zttc.itat.model.Group;

@Repository("groupHibernateDao")
public class GroupHibernateDao extends BaseDao<Group> implements IGroupDao {


}
