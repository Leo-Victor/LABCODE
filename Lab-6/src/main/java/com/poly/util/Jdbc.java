package com.poly.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dburl = "jdbc:sqlserver://localhost;database=HRM";
	static String username = "khoa123";
	static String password = "123456";
	static {
		try { // nạp driver
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	static {
		try {
			String sql = "{CALL spSelect…}";
			Object[] values = { "E01", "Nguyen Van A", 5000, "D01" };
			ResultSet resultSet = Jdbc.executeQuery(sql, values);
			while(resultSet.next()) {
			String value = resultSet.getString("column");
			//...
			System.out.println(value);
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			try {
			String sql = "{CALL spInsert…, spUpdate...?, spDelete…?}";
			Object[] values = { "E01", "Nguyen Van A", 5000, "D01" };
			int rows = Jdbc.executeUpdate(sql, values);
			System.out.println(rows);
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
//	static {
////		try {
////			String sql = "SELECT...";
////			ResultSet resultSet = Jdbc.executeQuery(sql);
////			while(resultSet.next()) {
////			String value = resultSet.getString("column");
////			//...
////			System.out.println(value);
////			}
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		try {
////		    String sql = "SELECT * FROM Employees WHERE DepartmentId = ?";
//			String sql = "SELECT...?";
//		    Object[] values = { "D01" };
//
//		    ResultSet resultSet = Jdbc.executeQuery(sql, values);
//
//		    while (resultSet.next()) {
//		        String id = resultSet.getString("Id");
//		        String fullname = resultSet.getString("Fullname");
//		        double salary = resultSet.getDouble("Salary");
//
//		        System.out.println(id + " - " + fullname + " - " + salary);
//		    }
//
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
//		try {
//			String sql = "INSERT...?, UPDATE...?, DELETE…?";
//			//String values = {};
//			Object[] values = { "E01", "Nguyen Van A", 5000, "D01" };	
//			int rows = Jdbc.executeUpdate(sql, values);
//			System.out.println(rows);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////			String sql = "INSERT..., UPDATE..., DELETE…";
////			int rows = Jdbc.executeUpdate(sql);
////			System.out.println(rows);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//	}
	
	/**Mở kết nối*/
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dburl, username, password);
	}
	/**Thao tác dữ liệu*/
	public static int executeUpdate(String sql, Object... values) throws SQLException {
		Connection connection = getConnection();
		//Statement statement = connection.createStatement();
//		PreparedStatement statement = connection.prepareStatement(sql);
//		for (int i = 0; i < values.length; i++) {
//			statement.setObject(i + 1, values[i]);
//		}
//		return statement.executeUpdate(sql);
		CallableStatement statement = connection.prepareCall(sql);
		for (int i = 0; i < values.length; i++) {
		statement.setObject(i + 1, values[i]);
		}
		return statement.executeUpdate();
	}
	/**Truy vấn dữ liệu*/
	public static ResultSet executeQuery(String sql, Object... values) throws SQLException {
		Connection connection = getConnection();
//		Statement statement = connection.createStatement();
//		return statement.executeQuery(sql);
//		PreparedStatement statement = connection.prepareStatement(sql);
//		for (int i = 0; i < values.length; i++) {
//			statement.setObject(i + 1, values[i]);
//		}
//		return statement.executeQuery();
		CallableStatement statement = connection.prepareCall(sql);
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
		return statement.executeQuery();
	}
	
	
}