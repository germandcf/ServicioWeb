package com.activos.ws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/Servicios")
@ApplicationPath("/Activos")
public class servicioActivos extends Application 
{
	@GET
	@Path("hola")
	@Produces(MediaType.APPLICATION_JSON)
	public String hola(String saludo)
	{
		return "hola mundo";
		
	}

}
