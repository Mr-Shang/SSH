package org.zttc.itat.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zttc.itat.model.User;
import org.zttc.itat.service.IGroupService;
import org.zttc.itat.service.IUserService;

import javax.annotation.Resource;

@SuppressWarnings("serial")
/**
 * 此时等于用Spring来创建了userAction对象,在struts的配置文件中写action的class的时候
 * 就不能写类，而应该是userAction中对象
 * @author Administrator
 *
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user;

	private IUserService userService;
	private IGroupService groupService;
	private int gid;
	
	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IGroupService getGroupService() {
		return groupService;
	}
	@Resource
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	@Override
	public User getModel() {
		if(user==null) user = new User();
		return user;
	}
	
	public String addInput() {
		ActionContext.getContext().put("gs", groupService.listAllGroup());
		return SUCCESS;
	}
	
	public void validateAdd() {
		if(user.getUsername()==null||"".equals(user.getUsername())) {
			this.addFieldError("username","用户名不能为空");
		}
		if(user.getNickname()==null||"".equals(user.getNickname())) {
			this.addFieldError("nickname","用户昵称不能为空");
		}
		//如果有错误，得需要重新调用addInput方法把组的信息设置进去
		if(this.hasFieldErrors()) {
			addInput();
		}
	}
	
	public String add() {
		userService.add(user, gid);
		ActionContext.getContext().put("url","/user_list.action");
		return "redirect";
	}
	
	public String list() {
		ActionContext.getContext().put("us", userService.findUser());
		return SUCCESS;
	}
	
	public String delete() {
		userService.delete(user.getId());
		ActionContext.getContext().put("url","/user_list.action");
		return "redirect";
	}
	
	public String updateInput() {
		ActionContext.getContext().put("gs", groupService.listAllGroup());
		User tu = userService.load(user.getId());
		user.setNickname(tu.getNickname());
		user.setPassword(tu.getPassword());
		user.setUsername(tu.getUsername());
		this.setGid(tu.getGroup().getId());
		return SUCCESS;
	}
	
	public String update() {
		User tu = userService.load(user.getId());
		tu.setNickname(user.getNickname());
		tu.setUsername(user.getUsername());
		userService.update(tu,gid);
		ActionContext.getContext().put("url","/user_list.action");
		return "redirect";
	}
}
