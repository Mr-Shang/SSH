package org.zttc.itat.template;

public class MyJdbcTemplate {

	private void beginConnection() {
		System.out.println("begin connection");
	}
	
	private void closeConnection() {
		System.out.println("close connection");
	}
	/**
	 * 调用方法,传入一个钩子函数的接口
	 */
	public void execute(MyCallback call) {
		beginConnection();
		call.doInTemplate();
		closeConnection();
	}
	
	/**
	 * 将所有要实现的方法都创建在模板中
	 */
	
	public void add(final int id) {
		execute(new MyCallback() {
			@Override
			public void doInTemplate() {
				System.out.println("add:"+id);
			}
		});
	}
	
	public void delete(final int id) {
		execute(new MyCallback() {
			
			@Override
			public void doInTemplate() {
				System.out.println("delete:"+id);
			}
		});
	}
}
