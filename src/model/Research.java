package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Research {
	/// Connect to the DB
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/researcher", "root", "");

			// For testig
			System.out.print("Succesfully connected");
		
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	         //Insert Buyers
			public String insertResearch(String Res_ID, String Res_type, String Res_note, String Res_price, String Ruser_ID)
			{ 
				Connection con = connect();
				String output = "";
				try
				 { 
					  
					 if (con == null) 
					 { 
					    return "Error while connecting to the database"; 
					 } 
					 
					 // create a prepared statement
					 String query = " insert into research (`Res_ID`,`Res_type`,`Res_note`,`Res_price`,`Ruser_ID`)"+ " values (?, ?, ?, ?, ?)"; 
					 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					 // binding values
					 preparedStmt.setString(1,Res_ID ); 
					 preparedStmt.setString(2, Res_type); 
					 preparedStmt.setString(3, Res_note); 
					 preparedStmt.setString(4, Res_price); 
					 preparedStmt.setString(5, Ruser_ID);
					
					 
					//execute the statement
					 
					 preparedStmt.execute(); 
					 con.close();
					 //System.out.println(query);
					 
					 output = "Inserted successfully"; 
				 } 
				
				catch (Exception e) 
				 { 
					 output = "Error while inserting"; 
					 
					System.err.println(e.getMessage()); 
				 } 
				//binding values
				return output; 
			}

			//Read the Buyers
			public String readResearch()
			{ 
				 String output = ""; 
				 
				 try
				 { 
				
			     Connection con = connect(); 
				 if (con == null) 
				 { 
					 return "Error while connecting to the database for reading."; 
				 } 
				 
				 
				 // Prepare the html table to be displayed
				 output = "<table border='1'>"
				 		 + "<tr><th>Research ID</th>" 
						 +"<th>Research Type</th>"
						 + "<th>Reserch Note</th>"
						 + "<th>Research price</th>" 
						 +"<th>User ID</th>"
						 + "<th>Update</th><th>Remove</th></tr>"; 
				 
				 String query = "select * from research"; 
				 
				 Statement stmt = (Statement) con.createStatement(); 
				 ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query); 
				 
				 // iterate through the rows in the result set
				 while (rs.next()) 
				 { 
					 String Res_ID = Integer.toString(rs.getInt("Res_ID")); 
					 String Res_type = rs.getString("Res_type"); 
					 String Res_note = rs.getString("Res_note"); 
					 String Res_price = rs.getString("Res_price"); 
					 String Ruser_ID  = rs.getString("Ruser_ID"); 
				
					 // Add a row into the html table
					 output += "<tr><td>" + Res_ID + "</td>"; 
					 output += "<td>" + Res_type + "</td>"; 
					 output += "<td>" + Res_note + "</td>";
					 output += "<td>" + Res_price + "</td>";
					 output += "<td>" + Ruser_ID + "</td>"; 
				
					 
					 // buttons
					 output += "<td><input name='btnUpdate' " 
					 + " type='button' value='Update' onclick = ></td>"
					 + "<td><form method='post' action='buyers.jsp'>"
					 + "<input name='btnRemove' " 
					 + " type='submit' value='Delete'>"
					 + "<input name='BuyerID' type='hidden' " 
					 + " value='" + Res_ID + "'>" 
					 + "</form></td></tr>"; 
				 } 
				 
				// con.close(); 
				
				     // Complete the html table
				     output += "</table>"; 
				 } 
				 
				catch (Exception e) 
				 { 
					 output = "Error while reading the Research."; 
					 System.err.println(e.getMessage()); 
				 } 
				
				
				return output; 
			}

	// Update buyers in the table
	public String updateResearch(String Res_ID, String Res_type, String Res_note, String Res_price)
			{ 
				 String output = ""; 
				 try
				 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for updating."; 
					 
				 } 
				 // create a prepared statement
				 String query = "UPDATE research SET Res_type=?,Res_note=?,Res_price=? WHERE Res_ID=? ";
					
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 // binding values
				 preparedStmt.setString(1, Res_ID); 
				 preparedStmt.setString(2, Res_type); 
				 preparedStmt.setString(3, Res_note); 
				 preparedStmt.setString(4, Res_price); 
			
				 
				 // execute the statement
				    preparedStmt.execute(); 
				    con.close(); 
				    output = "Updated successfully"; 
				 } 
				 
				 catch (Exception e) 
				 { 
				     output = "Error while updating the Research."; 
				     System.err.println(e.getMessage()); 
				 } 
				 
				 return output; 
				 }

	// Delete buyer in the table
	public String deleteResearch(String Res_ID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from research where Res_ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(Res_ID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the Research.";
			System.err.println(e.getMessage());
		}

		return output;
	}
}

