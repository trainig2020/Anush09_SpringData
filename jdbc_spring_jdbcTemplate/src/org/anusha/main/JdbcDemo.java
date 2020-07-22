package org.anusha.main;

import org.anusha.dao.JdbcDaoImpl;
import org.anusha.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

		//Circle circle = dao.getCircle(1);
		//System.out.println(circle.getName());
System.out.println(dao.getCircleCount());
	}
}

