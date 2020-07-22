package org.anusha.main;

import org.anusha.dao.JdbcDaoImpl;
import org.anusha.dao.SimpleJdbcDaoImpl;
import org.anusha.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

		//Circle circle = dao.getCircle(1);
		//System.out.println(circle.getName());
        //System.out.println(dao.getCircleCount());
		SimpleJdbcDaoImpl dao1 = ctx.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
		
		System.out.println(dao1.getCircleCount());
		//System.out.println(dao.getAllCircle().size());
		
		//dao.createTriangleTable( );

		
	}
}

