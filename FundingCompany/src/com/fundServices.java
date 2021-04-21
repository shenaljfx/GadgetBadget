package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import controller.fundController;
import model.Funds;

@Path("/funds")
public class fundServices {
	
	fundController funds = new fundController();
	
	
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		
		public String readAllFunds() {
			return funds.ViewFunds();
			
		}
		
		
		
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_HTML)
		
		public String enterFund(String FundData) {
			
			JsonObject djsonObj = new JsonParser().parse(FundData).getAsJsonObject();
			
			Funds fund = new Funds();
			
			fund.setrUserName(djsonObj .get("rUserName").getAsString());
			fund.setrUserAddress(djsonObj .get("rUserAddress").getAsString());
			fund.setrUserType(djsonObj .get("rUserType").getAsString());
			fund.setEmail(djsonObj .get("email").getAsString());
			
			String output = funds.addFunds(fund);
			return output;
		}
		
		
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String deleteFund(String FundData) {
			
			JsonObject doc = new JsonParser().parse(FundData).getAsJsonObject();


			Funds fund = new Funds();
			
	    	fund.setResId(doc.get("resId").getAsInt());
		
			String output = funds.deleteFunds(fund);
			return output;
		}
		
		
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateFunds(String FundData) {

			
			JsonObject djsonObj = new JsonParser().parse(FundData).getAsJsonObject();

			
			Funds fund = new Funds();

			fund.setResId(djsonObj.get("resId").getAsInt());
			fund.setrUserName(djsonObj.get("rUserName").getAsString());
			fund.setrUserAddress(djsonObj.get("rUserAddress").getAsString());
			fund.setrUserType(djsonObj.get("rUserType").getAsString());
			fund.setEmail(djsonObj.get("email").getAsString());

			
			String output = funds.updateFunds(fund);
			return output;
		}
			

}
