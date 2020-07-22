package com.anusha.main;

import com.anusha.dao.JdbcDaoImpl;
import com.anusha.model.Circle;

public class JdbcDemo {
	public static void main(String[] args) {

		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());

	}
}

