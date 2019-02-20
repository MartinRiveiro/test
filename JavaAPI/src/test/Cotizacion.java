package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Application;
import javax.json.JsonArray;
import javax.servlet.Servlet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.servlet.http.*;

@Path("/Cotizacion")
public class Cotizacion {
	
	@Path("/Dolar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray CotizacionDolar()
	{
		JsonArray response=null;
		try 
		{
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("https://www.bancoprovincia.com.ar/Principal/Dolar");
			response = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		return response;	
	}
	
	@Path("/Pesos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray CotizacionPesos(HttpServletResponse res)
	{
		JsonArray json=null;
		res.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);	
		return json;
							
	}
	
	@Path("/Real")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray CotizacionReal(HttpServletResponse res)
	{
		JsonArray json=null;
		res.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);	
		return json;
							
	}
		
		
	
	

}
	