package org.zttc.itat.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zttc.itat.model.Group;
import org.zttc.itat.service.IGroupService;

import javax.annotation.Resource;

@Controller("groupAction")
@Scope("prototype")
public class GroupAction extends ActionSupport implements ModelDriven<Group>{
	private static final long serialVersionUID = -3044128410376916787L;
	private IGroupService groupService;
	private Group group;
	private int cid;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public Group getModel() {
		if(group==null) group = new Group();
		return group;
	}
	public IGroupService getGroupService() {
		return groupService;
	}
	@Resource
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	
	public String list() {
		ActionContext.getContext().put("gl", groupService.listAllGroup());
		return SUCCESS;
	}
	
	public String show() {
		System.out.println(cid);
		group = groupService.load(cid);
		return SUCCESS;
	}
	
	public String delete() {
		groupService.delete(group.getId());
		ActionContext.getContext().put("url","/group_list.action");
		return "redirect";
	}
	
	public String updateInput() {
		Group tg = groupService.load(group.getId());
		group.setName(tg.getName());
		return "success";
	}
	
	public String update() {
		Group tg = groupService.load(group.getId());
		tg.setName(group.getName());
		groupService.update(tg);
		ActionContext.getContext().put("url", "/group_list.action");
		return "redirect";
	}
	
	public String addInput() {
		return SUCCESS;
	}
	
	public String add() {
		groupService.add(group);
		ActionContext.getContext().put("url","/group_list.action");
		return "redirect";
	}
	/**
	 * 服务器端验证add的方法
	 */
	public void validateAdd() {
		if(group.getName()==null||"".equals(group.getName().trim())) {
			this.addFieldError("name","组名称不能为空");
		}
	}
	
	
}
