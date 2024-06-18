package org.anshuahi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.anshuahi.config.DatabaseConfig;
import org.anshuahi.entity.User;


public class UsersModel {
	public List<User>  listUser(){
		List<User> listUsers = new ArrayList<User>();
		
		// Step 1: Connection object init
		Connection connect = DatabaseConfig.getConnection();
		System.out.println("lsitUsers: " + connect);
		Statement stmt = null;
		ResultSet result = null;
		if(connect == null) {
			return listUsers;
		}
		
		// Step 2; create the DB query
		String query = "select * from users";
		try {
			stmt = connect.createStatement();			
			// Step 3: Execution of statement;
			
			result = stmt.executeQuery(query);
			
			while(result.next()) {
				listUsers.add(new User(result.getInt("user_id"), result.getString("username"), result.getString("email")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return listUsers;
	}

	public void addUser(User newUser) {
		Connection connect = null;
		PreparedStatement stmt = null;
		
		try {
			connect = DatabaseConfig.getConnection();
			System.out.println("add User: " + connect);
			String username = newUser.getUsername();
			String email = newUser.getEmail();
			String query = "insert into users (username, email) values (?, ?)";
			
			stmt = connect.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, email);
			
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateUser(User newUser) {
		Connection connect = null;
		PreparedStatement stmt = null;
		
		try {
			connect = DatabaseConfig.getConnection();
			System.out.println("add User: " + connect);
			String username = newUser.getUsername();
			String email = newUser.getEmail();
			String query = "update users set username = ?, email = ? where user_id = ?";
			
			stmt = connect.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, email);
			stmt.setInt(3, newUser.getUser_id());
			
			stmt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deleteUser(User newUser) {
		Connection connect = null;
		PreparedStatement stmt = null;
		
		try {
			connect = DatabaseConfig.getConnection();
			System.out.println("add User: " + connect);
			String query = "delete from users where user_id = ?";
			
			stmt = connect.prepareStatement(query);
			stmt.setInt(1, newUser.getUser_id());
			
			stmt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
