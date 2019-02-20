package test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.riveiro.dao.DBManager;

@Path("/user")
public class User {
	
	@Path("/registrar")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	
	public HashMap<String,String> SetNuevoUsuario(@FormParam("nombre") String strNombre,@FormParam("apellido") String strApellido,@FormParam("email") String strEmail, @FormParam("password") String strPassword ) {
		
		HashMap<String,String> h = new HashMap<String,String>();
		
		int i= DBManager.NuevoUsuario(strNombre, strApellido, strEmail, strPassword);


		if(i>0)
		{
			h.put("registro", "exitoso");
		}
		else
		{
			h.put("registro","fallido");
		}
		
		return h;
	}
	
	@Path("/modificar")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	
	public HashMap<String,String> ModifUsuario(@FormParam("id") int intId,@FormParam("nombre") String strNombre,@FormParam("apellido") String strApellido,@FormParam("email") String strEmail, @FormParam("password") String strPassword ) {
		
		HashMap<String,String> h = new HashMap<String,String>();
		
		int i= DBManager.ModificarUsuario(intId, strNombre, strApellido, strEmail, strPassword);
		if(i>0)
		{
			h.put("modificacion", "exitosa");
		}
		else
		{
			h.put("modificacion","fallida");
		}
		
		return h;
	}
	
	@Path("/eliminar")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	
	public HashMap<String,String> EliminarUsuario(@FormParam("id") int intId) 
	{
		
		HashMap<String,String> h = new HashMap<String,String>();
		
		int i= DBManager.EliminarUsuario(intId);
		if(i>0)
		{
			h.put("eliminacion", "exitosa");
		}
		else
		{
			h.put("eliminacion","fallida");
		}
		
		return h;
	}
	
	@Path("/usuarios")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User_model> GetUsuarios()
	{
		ArrayList<User_model> listUsuarios = new ArrayList<User_model>();
		listUsuarios = DBManager.ObtenerUsuarios();
		return listUsuarios;
		
		
	}
	

}
