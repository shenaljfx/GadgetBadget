package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReviewManagement {
	
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
	
	//Insert Items

		public String insertItem( String RP_Name, String RP_StarRate,String RP_Feedback) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for inserting.";
				}
				// create a prepared statement
				String query = " insert into Review_Management(`ResearchProject_ID`,`RP_Name`,`RP_StarRate`,`RP_Feedback`)"
						+ " values (?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, RP_Name);
				preparedStmt.setString(3, RP_StarRate);
				preparedStmt.setString(4, RP_Feedback);
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

		//Read Items
		
		public String readItems() {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr><th>ResearchProject_ID</th><th>RP_Name</th><th>RP_StarRate</th><th>RP_Feedback</th><th>Update</th><th>Remove</th></tr>";
				String query = "select * from Review_Management";
				Statement stmt = (Statement) con.createStatement();
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next()) {
					String ResearchProject_ID = Integer.toString(rs.getInt("ResearchProject_ID"));
					String RP_Name = rs.getString("RP_Name");
					String RP_StarRate = Integer.toString(rs.getInt("RP_StarRate"));
					String RP_Feedback = rs.getString("RP_Feedback");
					
					// Add into the html table
					output += "<tr><td>" + ResearchProject_ID + "</td>";
					output += "<td>" + RP_Name + "</td>";
					output += "<td>" + RP_StarRate + "</td>";
					output += "<td>" + RP_Feedback + "</td>";
					
					// buttons
					output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
							+ "<td><form method=\"post\" action=\"items.jsp\">"
							+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
							+ "<input name=\"itemID\" type=\"hidden\" value=\"" + ResearchProject_ID + "\">" + "</form></td></tr>";
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

		//Update items
		
		public String updateItem( String ResearchProject_ID ,String RP_Name, String RP_StarRate, String RP_Feedback) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				// create a prepared statement
				String query = "UPDATE Review_Management SET RP_Name=?,RP_StarRate=?,RP_Feedback=? WHERE ResearchProject_ID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setString(1, RP_Name);
				preparedStmt.setString(2, RP_StarRate);
				preparedStmt.setString(3, RP_Feedback);
				preparedStmt.setInt(4,Integer.parseInt( ResearchProject_ID));
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

		//Delete Items
		
		public String deleteItem(String ResearchProject_ID) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from Review_Management where ResearchProject_ID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(ResearchProject_ID));
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
