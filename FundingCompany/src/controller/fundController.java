package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBConnection;
import model.Funds;

public class fundController {
	
	DBConnection dbObj = new DBConnection();
	
public String ViewFunds() {
		
		String output = "";
		
		Funds funds = new Funds();
		
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			//Table to display the Funds
			output = "<table border=\"1\"><tr><th>ResId</th>"
					+ "<th>User Name</th><th>User Address</th>" + "<th>Type</th>" + "<th>E-mail</th>"+"</tr>";
			
			String query = "select * from funding_company";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				funds.setResId(rs.getInt("resId"));
				funds.setrUserName(rs.getString("rUserName"));
				funds.setrUserAddress(rs.getString("rUserAddress"));
				funds.setrUserType(rs.getString("rUserType"));
				funds.setEmail(rs.getString("email"));
				
				
				output += "<tr><td>" + funds.getResId() + "</td>";
				output += "<td>" + funds.getrUserName() + "</td>";
				output += "<td>" + funds.getrUserAddress() + "</td>";
				output += "<td>" + funds.getrUserType() + "</td>";
				output += "<td>" + funds.getEmail() + "</td>";
					
			}
			con.close();
			output += "</table>";
			
		}catch(Exception e){
			output = "Error while reading.";
			System.err.println(e.getMessage());
		}
		
		return output;
		
	}


public String deleteFunds(Funds funds) {
	
	String output = "";
	
	try {

		Connection con = dbObj.connect();
		if (con == null) {
			return "Error while connecting to the database for deleting.";
		}

		// create a prepared statement
		String query = "DELETE FROM funding_company WHERE resId=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);

		
		 preparedStmt.setInt(1, funds.getResId());
		
		preparedStmt.execute();
		con.close();
		output = "[ resId : "+funds.getResId()+" ] Deleted successfully";

	} catch (Exception e) {

		output = "Error while deleting :" + funds.getResId();
		System.err.println(e.getMessage());
	}

	return output;
}


	public String addFunds(Funds funds) {
	
		String output = "";
		try {

			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create the prepared statement
			String query = " INSERT INTO funding_company (rUserName, rUserAddress, rUserType, email) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

		
			preparedStmt.setString(1, funds.getrUserName());
			preparedStmt.setString(2, funds.getrUserAddress());
			preparedStmt.setString(3, funds.getrUserType());
			preparedStmt.setString(4, funds.getEmail());
		
		
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";

		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
	
	
		return output;
	
	}
	
	
	public String updateFunds(Funds funds) {

		String output = "";

		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// creating a prepared statement
			String query = "UPDATE funding_company SET rUserName=?,rUserAddress=?,rUserType=?,email=? WHERE resId =?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			

			
			preparedStmt.setString(1,funds.getrUserName());
			preparedStmt.setString(2, funds.getrUserAddress());
			preparedStmt.setString(3, funds.getrUserType());
			preparedStmt.setString(4, funds.getEmail());
			preparedStmt.setInt(5, funds.getResId());
			
			
			preparedStmt.execute();
			con.close();
			output = "[ ID : "+funds.getResId()+" ] Updated successfully ";
			
		} catch (Exception e) {
			output = "Error while updating " + funds.getResId();
			System.err.println(e.getMessage());
		}
		return output;
	}

}
