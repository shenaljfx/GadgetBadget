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

import controller.reqController;
import model.Req;

@Path("/req")
public class reqServices {
	
	reqController reqs = new reqController();
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	public String readAllRequirements() {
		return reqs.ViewRequirement();
		
	}
	
	
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	
	public String enterRequirements(String ReqData) {
		
		JsonObject djsonObj = new JsonParser().parse(ReqData).getAsJsonObject();
		
		Req req = new Req();
		
		req.setResId(djsonObj .get("resId").getAsInt());
		req.setReqType(djsonObj .get("reqType").getAsString());
		req.setReqNote(djsonObj .get("reqNote").getAsString());
		
		String output = reqs.addRequirement(req);
		return output;
	}
	
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String deleteRequirement(String ReqData) {
		
		JsonObject doc = new JsonParser().parse(ReqData).getAsJsonObject();


		Req req = new Req();
		
    	req.setReqId(doc.get("reqId").getAsInt());
	
		String output = reqs.deleteRequirement(req);
		return output;
	}
	
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateRequirement(String ReqData) {

		
		JsonObject djsonObj = new JsonParser().parse(ReqData).getAsJsonObject();

		
		Req req = new Req();

		req.setReqId(djsonObj.get("reqId").getAsInt());
		req.setResId(djsonObj.get("resId").getAsInt());
		req.setReqType(djsonObj.get("reqType").getAsString());
		req.setReqNote(djsonObj.get("reqNote").getAsString());

		
		String output = reqs.updateRequirement(req);
		return output;
	}

}
