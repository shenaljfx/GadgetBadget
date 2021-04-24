package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DBUtil.DBConnection;
import model.Req;

public class reqController {
	
	DBConnection dbObj = new DBConnection();
	
	public String ViewRequirement() {
			
			String output = "";
			
			Req req = new Req();
			
			try {
				Connection con = dbObj.connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}
				//Table to display the Requirements
				output = "<table border=\"1\"><tr><th>ReqId</th>"
						+ "<th>ResId</th>" + "<th>Req_Type</th>" + "<th>Req_Note</th>" + "</tr>";
				
				String query = "select * from requirement";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					
					req.setReqId(rs.getInt("reqId"));
					req.setResId(rs.getInt("resId"));
					req.setReqType(rs.getString("reqType"));
					req.setReqNote(rs.getString("reqNote"));
					
					output += "<tr><td>" + req.getReqId() + "</td>";
					output += "<td>" + req.getResId() + "</td>";
					output += "<td>" + req.getReqType() + "</td>";
					output += "<td>" + req.getReqNote() + "</td>";
						
				}
				con.close();
				output += "</table>";
				
			}catch(Exception e){
				output = "Error while reading.";
				System.err.println(e.getMessage());
			}
			
			return output;
			
		}


	public String deleteRequirement(Req req) {
		
		String output = "";
		
		try {

			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "DELETE FROM requirement WHERE reqId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			
			 preparedStmt.setInt(1, req.getReqId());
			
			preparedStmt.execute();
			con.close();
			output = "[ reqId : "+req.getReqId()+" ] Deleted successfully";

		} catch (Exception e) {

			output = "Error while deleting :" + req.getReqId();
			System.err.println(e.getMessage());
		}

		return output;
	}


		public String addRequirement(Req req) {
		
			String output = "";
			try {

				Connection con = dbObj.connect();
				if (con == null) {
					return "Error while connecting to the database";
				}

				// create the prepared statement
				String query = " INSERT INTO requirement (resId, reqType, reqNote) VALUES (?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

			
				preparedStmt.setInt(1, req.getResId());
				preparedStmt.setString(2, req.getReqType());
				preparedStmt.setString(3, req.getReqNote());
			
			
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
		
		
		public String updateRequirement(Req req) {

			String output = "";

			try {
				Connection con = dbObj.connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				// creating a prepared statement
				String query = "UPDATE requirement SET resId=?,reqType=?,reqNote=? WHERE reqId =?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				

				
				preparedStmt.setInt(1,req.getResId());
				preparedStmt.setString(2, req.getReqType());
				preparedStmt.setString(3, req.getReqNote());
				preparedStmt.setInt(4, req.getReqId());
				
				
				preparedStmt.execute();
				con.close();
				output = "[ ID : "+req.getReqId()+" ] Updated successfully ";
				
			} catch (Exception e) {
				output = "Error while updating " + req.getReqId();
				System.err.println(e.getMessage());
			}
			return output;
		}

}
