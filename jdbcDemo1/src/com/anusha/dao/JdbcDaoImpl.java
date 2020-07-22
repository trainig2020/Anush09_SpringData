package com.anusha.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.anusha.model.Circle;

public class JdbcDaoImpl {
	public Circle getCircle(int circleId) {
		//Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/circle","root","root");	
			PreparedStatement ps = conn1.prepareStatement("SELECT * FROM circle where id=?");
			ps.setInt(1, circleId);

			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
			return circle;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} /*finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}*/
		}

	}






/*package com.anusha2;

import java.sql.*;

public class StatementDemo {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_jdbc","root","root");	
        Statement st=con.createStatement();
        String sqlQuery="insert into employees values('Aparna',408,30000,'banglore')";
      // String sqlQuery="delete from employees where en0=409";
     // String sqlQuery="update employees set ename='anu',esal=100000 where eno=490";
        int count=st.executeUpdate(sqlQuery);
        System.out.println("Record Inserted count:"+count);
        con.close();
        System.out.println("Connection closed");
        
	}

}*/
