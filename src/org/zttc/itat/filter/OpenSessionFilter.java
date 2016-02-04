package org.zttc.itat.filter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

public class OpenSessionFilter implements Filter {
	//Spring的工厂，在init中获取
	private static WebApplicationContext wac;
	private static SessionFactory factory;
	private static ThreadLocal<Session> sessionHolder = new ThreadLocal<Session>();
	
	private static void setSession(Session session) {
		sessionHolder.set(session);
	}
	
	public static Session getSession() {
		return sessionHolder.get();
	}
	
	private static void removeSession() {
		sessionHolder.remove();
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//开启session
		/**
		 * 需要获取Spring的工厂
		 * 如果使用new ClassPathXmlApplicationContext()这种方式来获取Spring的工厂，最大的问题是
		 * 这是一个新工厂，和Servlet初始化时的工厂是两个对象
		 * 必须通过其他方法来获取
		 * 在Spring中可以通过Web
		 */
		try {
			System.out.println("aaaa");
			//设置session
			setSession(factory.openSession());
			chain.doFilter(req, resp);
		} finally {
			//关闭session
			removeSession();
		}
		//关闭session
	}

	/**
	* 以下方法用来获取Spring的工厂和Hibernate的SessionFactory
	**/
	@Override
	public void init(FilterConfig cfg) throws ServletException {
		/**
		 * 使用WebApplcaiontContextUtils.getWebApplicationContext(ServletContext)来获取WEb中的Spring工厂
		 * 这种手段非常重要，一定要熟悉
		 */
		wac = WebApplicationContextUtils.getWebApplicationContext(cfg.getServletContext());
		factory = (SessionFactory)wac.getBean("sessionFactory");
	}

}
