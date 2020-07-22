package org.anusha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.anusha.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {
	 @Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimpleJdbcCall simplejdbcCall;

	public DataSource getDataSource() {
		return dataSource;
	}

	//@Autowired
	public void setDataSource(DataSource dataSource) {
		// this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	 * public Circle getCircle(int circleId) { Connection conn1 = null;
	 * 
	 * try {
	 * 
	 * conn1 = dataSource.getConnection();
	 * 
	 * PreparedStatement ps = conn1
	 * .prepareStatement("SELECT * FROM circle where id=?"); ps.setInt(1,
	 * circleId);
	 * 
	 * Circle circle = null; ResultSet rs = ps.executeQuery(); if (rs.next()) {
	 * circle = new Circle(circleId, rs.getString("name")); } rs.close();
	 * ps.close(); return circle; } catch (Exception e) { throw new
	 * RuntimeException(e); } finally { try { conn1.close(); } catch
	 * (SQLException e) { }
	 * 
	 * }
	 * 
	 * }
	 */
	public Map<String, Object> getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		// jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForMap(sql);

	}

	public String getCircleName(int circleId) {
		String sql = "SELECT NAME FROM CIRCLE WHERE ID=?";
		// jdbcTemplate.queryForObject(sql, String.class);
		return jdbcTemplate.queryForObject(sql, new Object[] { circleId },
				String.class);
	}

	public Circle getCircleforId(int circleId) {
		String sql = "SELECT * FROM CIRCLE WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { circleId },
				new CircleMapper());
	}

	public List<Circle> getAllCircle() {
		String sql = "SELECT * FROM CIRCLE ";
		return jdbcTemplate.query(sql, new CircleMapper());

	}

	/*
	 * public void insertCircle(Circle circle){ String sql =
	 * "INSERT INTO CIRCLE (ID, NAME) VALUES(?,?)"; jdbcTemplate.update(sql,new
	 * Object[] {circle.getId(),circle.getName()});
	 * 
	 * 
	 * }
	 */
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES(:id,:name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",circle.getId()).addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);

	}

	public void createTriangleTable() {
		String sql = "CREATE TABLE TRIANGLE (ID INTEGER,NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);

	}

	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;

		}

	}
}

/*
 * package com.anusha2;
 * 
 * import java.sql.*;
 * 
 * public class StatementDemo { public static void main(String[] args) throws
 * Exception { // TODO Auto-generated method stub
 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection
 * con=DriverManager.getConnection
 * ("jdbc:mysql://localhost:3306/employee_jdbc","root","root"); Statement
 * st=con.createStatement(); String
 * sqlQuery="insert into employees values('Aparna',408,30000,'banglore')"; //
 * String sqlQuery="delete from employees where en0=409"; // String
 * sqlQuery="update employees set ename='anu',esal=100000 where eno=490"; int
 * count=st.executeUpdate(sqlQuery);
 * System.out.println("Record Inserted count:"+count); con.close();
 * System.out.println("Connection closed");
 * 
 * }
 * 
 * }
 */
