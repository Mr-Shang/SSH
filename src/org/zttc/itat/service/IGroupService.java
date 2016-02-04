package org.zttc.itat.service;

import java.util.List;

import org.zttc.itat.model.Group;

public interface IGroupService {
	public void add(Group group);
	public void delete(int id);
	public void update(Group group);
	public Group load(int id);
	public List<Group> listAllGroup();
}
