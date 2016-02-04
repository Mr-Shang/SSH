package org.zttc.itat.template;

public class RoleDao extends MyJdbcTemplateByIn {
	
	private MyJdbcTemplate mt = new MyJdbcTemplate();
	
	public void add(int id){
		mt.add(id);
	}
	
	public void delete(int id) {
		mt.delete(id);
	}

	@Override
	public void run() {
		System.out.println("role add");
	}

	@Override
	public boolean isLog() {
		return false;
	}

}
