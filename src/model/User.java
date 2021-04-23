package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class User {
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	public String insertItem( String User_name, String User_address, String User_gender,String User_age,String User_title) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into reg_user(`User_ID`,`User_name`,`User_address`,`User_gender`,`User_age`,`User_title`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, User_name);
			preparedStmt.setString(3, User_address);
			preparedStmt.setString(4, User_gender);
			preparedStmt.setString(5, User_age);
			preparedStmt.setString(6, User_title);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String readItems() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}   
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>User_ID</th><th>User_name</th><th>User_address</th><th>User_gender</th><th>User_age</th><th>User_title</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from reg_user";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String User_ID = Integer.toString(rs.getInt("User_ID"));
				String User_name = rs.getString("User_name");
				String User_address = rs.getString("User_address");
				String User_gender = rs.getString("User_gender");
				String User_age = Integer.toString(rs.getInt("User_age"));
				String User_title = rs.getString("User_title");
				// Add into the html table
				output += "<tr><td>" + User_ID + "</td>";
				output += "<td>" + User_name + "</td>";
				output += "<td>" + User_address + "</td>";
				output += "<td>" + User_gender + "</td>";
				output += "<td>" + User_age + "</td>";
				output += "<td>" + User_title + "</td>";
				  
				// buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
						+ "<td><form method=\"post\" action=\"items.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
						+ "<input name=\"itemID\" type=\"hidden\" value=\"" + User_ID + "\">" + "</form></td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String updateItem( String User_ID ,String User_name, String User_address, String User_gender,String User_age,String User_title) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE reg_user SET User_name=?,User_address=?,User_gender=?,User_age=?,User_title=? WHERE User_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, User_name);
			preparedStmt.setString(2, User_address);
			preparedStmt.setString(3, User_gender);
			preparedStmt.setString(4, User_age);
			preparedStmt.setString(5, User_title);
			preparedStmt.setInt(6,Integer.parseInt( User_ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String deleteItem(String User_ID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from reg_user where User_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(User_ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	

}
