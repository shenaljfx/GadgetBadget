package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.ReviewManagement;

@Path("/ReviewManagement")
public class ReviewManagementService {
	
	ReviewManagement itemObj = new ReviewManagement();

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
	public String insertItem(@FormParam("RP_Name") String RP_Name, 
			@FormParam("RP_StarRate") String RP_StarRate,
			@FormParam("RP_Feedback") String H_Desc
			) 
	{
		String output = itemObj.insertItem( RP_Name,RP_StarRate,H_Desc);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String itemData) { // Convert the input string to a JSON object
		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();

		// Read the values from the JSON object
		String ResearchProject_ID = itemObject.get("ResearchProject_ID").getAsString();
		String RP_Name = itemObject.get("RP_Name").getAsString();
		String RP_StarRate = itemObject.get("RP_StarRate").getAsString();
		String RP_Feedback = itemObject.get("RP_Feedback").getAsString();

		String output = itemObj.updateItem(ResearchProject_ID, RP_Name, RP_StarRate,RP_Feedback);

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
		String ResearchProject_ID = doc.select("ResearchProject_ID").text();

		String output = itemObj.deleteItem(ResearchProject_ID);

		return output;
	}

}
