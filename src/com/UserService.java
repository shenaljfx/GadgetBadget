package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.User;

@Path("/User")
public class UserService {
	
	User itemObj = new User();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return itemObj.readItems();
		
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("User_name") String User_name, 
			@FormParam("User_address") String User_address, 
			@FormParam("User_gender") String User_gender,
			@FormParam("User_age") String User_age,
			@FormParam("User_title") String User_title
			) 
	{
		String output = itemObj.insertItem( User_name, User_address, User_gender, User_age, User_title);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String itemData) { 
		// Convert the input string to a JSON object
		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();

		// Read the values from the JSON object
		String User_ID = itemObject.get("User_ID").getAsString();
		String User_name = itemObject.get("User_name").getAsString();
		String User_address = itemObject.get("User_address").getAsString();
		String User_gender = itemObject.get("User_gender").getAsString();
		String User_age = itemObject.get("User_age").getAsString();
		String User_title = itemObject.get("User_title").getAsString();

		String output = itemObj.updateItem(User_ID, User_name, User_address, User_gender, User_age, User_title);

		return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemData)
	
	{
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(itemData, "", Parser.xmlParser()); 
		//Read the value from the element <itemID> 
		String User_ID = doc.select("User_ID").text();

		String output = itemObj.deleteItem(User_ID);

		return output;
	}
	
	



}
