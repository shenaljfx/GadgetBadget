package com;

import model.Research;


//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Research")
public class ResearchService {
	Research ResearchObj = new Research();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readResearch() {
		return ResearchObj.readResearch();
	}
  
	// inserBuyer() method
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertBuyer(@FormParam("Res_ID") String Res_ID, 
	 @FormParam("Res_type") String Res_type, 
	 @FormParam("Res_note") String Res_note, 
	 @FormParam("Res_price") String Res_price, 
	 @FormParam("Ruser_ID") String Ruser_ID)

	
	{ 
	 String output =  ResearchObj.insertResearch(Res_ID,Res_type,Res_note,Res_price,Ruser_ID); 
	 return output; 
	}
	
	//updateBuyer() method
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateBuyer(String researchData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject researchObject = new JsonParser().parse( researchData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String Res_ID = researchObject.get("Res_ID").getAsString(); 
	 String Res_type = researchObject.get("Res_type").getAsString(); 
	 String Res_note = researchObject.get("Res_note").getAsString(); 
	 String Res_price = researchObject.get("Res_price").getAsString(); 
	

	 String output = ResearchObj.updateResearch(Res_ID,Res_type,Res_note,Res_price); 
	
	 return output; 
	}
	
	// deleteBuyer() method
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteResearch(String ResearchData) 
	{ 
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(ResearchData, "", Parser.xmlParser()); 
	 
	//Read the value from the element <itemID>
	 String Res_ID = doc.select("Res_ID").text(); 
	 String output =  ResearchObj.deleteResearch(Res_ID); 
	
	 return output; 
	}
}