package org.zttc.itat.test;

import org.junit.Test;
import org.zttc.itat.template.MessageDao;
import org.zttc.itat.template.MyJdbcTemplateByIn;
import org.zttc.itat.template.RoleDao;

public class TestTemplate {

	@Test
	public void test01() {
		MyJdbcTemplateByIn mt = new RoleDao();
		mt.execute();
		MyJdbcTemplateByIn msgt = new MessageDao();
		msgt.execute();
		
		
	}
	
	@Test
	public void test02() {
		RoleDao rd = new RoleDao();
		rd.add(1);
	}
	
	@Test
	public void test03() {
		String hql = "select u from Student s";
		String f = hql.substring(0,hql.indexOf("from"));
		if(f.equals("")) {
			hql = "select count(*) "+hql;
		} else {
			hql = hql.replace(f, "select count(*) ");
		}
		System.out.println(hql);
	}
}
