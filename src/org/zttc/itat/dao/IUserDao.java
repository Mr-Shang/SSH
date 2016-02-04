package org.zttc.itat.dao;

import org.zttc.itat.model.User;


public interface IUserDao extends IBaseDao<User>{
	/**
	 * 获取某个组中的用户数量
	 * @param gid
	 * @return
	 */
	public long getGroupUserCount(int gid);
	/**
	 * 删除组中的用户
	 * @param gid
	 */
	public void deleteByGroup(int gid);
}
