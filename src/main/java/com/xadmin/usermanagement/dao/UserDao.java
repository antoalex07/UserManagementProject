package com.xadmin.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xadmin.usermanagement.bean.User;

public class UserDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?userSSL=false";
	private String jdbcUserName = "root";
	private String jdbcPswrd = "abc@1234";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "(name , email , country) VALUES" + "(? , ? , ?): ";
	private static final String SELECT_USERS_BY_ID = "SELECT id , name , email , country FROM users WHERE id = ? ";
	private static final String SELECT_ALL_USERS = "SELECT * FROM users";
	private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ? ";
	private static final String UPDATE_USERS_SQL = "UPDATE users SET name = ? , email = ? , country = ? WHERE id = ? ";
	
	public UserDao() {
		
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPswrd);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertUser(User user) throws SQLException{
		System.out.println(INSERT_USERS_SQL);
		try { Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		for(Throwable ex : e) {
			if(ex instanceof SQLException) {
				ex.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) ex).getSQLState());
				System.err.println("Error Code: " + ((SQLException) ex).getErrorCode());
				System.err.println("Message: " + ex.getMessage());
				Throwable t = ex.getCause();
				while(t != null) {
					System.out.println("Cause: " + t);
					t.getCause();
				}
			}
		}
	}
}
