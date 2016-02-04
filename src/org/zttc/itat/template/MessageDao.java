package org.zttc.itat.template;

public class MessageDao extends MyJdbcTemplateByIn {

	@Override
	public void run() {
		System.out.println("msg add");
	}

	@Override
	public boolean isLog() {
		return true;
	}

}
