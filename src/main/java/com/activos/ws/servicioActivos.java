package com.activos.ws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.List;

import com.activos.entidades.Activo_Fijo;
import com.activos.entidades.Area;
import com.activos.entidades.Persona;
import com.activos.model.activosBean;


@Path("/Servicios")
@ApplicationPath("/Activos")
public class servicioActivos extends Application 
{
	@GET
	@Path("ListarActivos")
	@Produces(MediaType.APPLICATION_JSON)
	
	//http://localhost:8080/ServiciosActivos/Activos/Servicios/ListarActivos
	public List<Activo_Fijo> GetAllActivos()
	{
	
		activosBean activosBean = new activosBean();
		List<Activo_Fijo> activos = activosBean.getActivoFijoAll();
		
		if(activos.size()==0){	
			Message message = new Message(404, "Busqueda sin resultados");
			Response reponse = Response.status(Status.NOT_FOUND).entity(message).build();
			throw new WebApplicationException(reponse); 
		}else 
			return activos;
		
	
	}
	
	@GET
	@Path("ConsultarActivosPorTipo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activo_Fijo> getConsultarPorTipo(@QueryParam("varTipo") String varTipo)
	{
		//http://localhost:8080/ServiciosActivos/Activos/Servicios/ConsultarActivosPorTipo?varTipo=mobiliario
		activosBean activosbean=new activosBean();
	
		List<Activo_Fijo> activos= activosbean.getActivoByType(varTipo);
		if(activos.size()==0){	
			Message message = new Message(404, "Busqueda sin resultados");
			Response reponse = Response.status(Status.NOT_FOUND).entity(message).build();
			throw new WebApplicationException(reponse); 
		}else 
			return activos;
	}
	
	@GET
	@Path("ListarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getPersonasAll()
	{
		//http://localhost:8080/ServiciosActivos/Activos/Servicios/ListarPersonas
		activosBean activosbean=new activosBean();
		
		List<Persona> personas= activosbean.getPersonaAll();
		if(personas.size()==0){	
			Message message = new Message(404, "Busqueda sin resultados");
			Response reponse = Response.status(Status.NOT_FOUND).entity(message).build();
			throw new WebApplicationException(reponse); 
		}else 
			return personas;
	}
	
	@GET
	@Path("ListarAreas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Area> getAreasAll()
	{
		//http://localhost:8080/ServiciosActivos/Activos/Servicios/ListarAreas
		activosBean activosbean=new activosBean();
		
		List<Area> Areas= activosbean.getAreaAll();
		if(Areas.size()==0){	
			Message message = new Message(404, "Busqueda sin resultados");
			Response reponse = Response.status(Status.NOT_FOUND).entity(message).build();
			throw new WebApplicationException(reponse); 
		}else 
			return Areas;
	}
	
	@GET
	@Path("BuscarActivosPorSerial")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activo_Fijo> getConsultarPorSerial(@QueryParam("Serial") String serial)
	{
		//http://localhost:8080/ServiciosActivos/Activos/Servicios/BuscarActivosPorSerial?Serial=1
		activosBean activosbean=new activosBean();
		List<Activo_Fijo> activos= activosbean.getActivosBySerial(serial);
		if(activos.size()==0){	
			Message message = new Message(404, "Busqueda sin resultados");
			Response reponse = Response.status(Status.NOT_FOUND).entity(message).build();
			throw new WebApplicationException(reponse); 
		}else 
			return activos;

	}
	
	@GET
	@Path("BuscarActivosPorFechaCompra")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activo_Fijo> getConsultarPorFechaCompra(@QueryParam("Fecha_Compra") String FechaCompra){

	//http://localhost:8080/ServiciosActivos/Activos/Servicios/BuscarActivosPorFechaCompra?FechaCompra=2015-02-01
	activosBean activosbean=new activosBean();
	List<Activo_Fijo> activos=activosbean.getActivosByFechaCompra(FechaCompra);
	if(activos.size()==0){	
		Message message = new Message(404, "Busqueda sin resultados");
		Response reponse = Response.status(Status.NOT_FOUND).entity(message).build();
		throw new WebApplicationException(reponse); 
	}else 
		return activos;

	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Message addActivos(Activo_Fijo a)
	{

		verificarDatos verificar= new verificarDatos();
		compararFechas cf= new compararFechas();
		if(verificar.activosVerificarDatosFaltantes(a)){
		if(cf.verificarFecha(a)){
			activosBean activosbean=new activosBean();
			activosbean.addActivos(a);
			
			Message message = new Message(200, "Operacion exitosa");
			return message;
		}else{
			Message message = new Message(400, cf.getMessage());
			Response reponse = Response.status(400).entity(message).build();
			throw new WebApplicationException(reponse);
		}
		}else{
			//faltan de datos
			Message message = new Message(404, "Faltan datos: "+ verificar.getDatoQueFalta());
			Response reponse = Response.status(400).entity(message).build();
			throw new WebApplicationException(reponse);
		}

	}
	
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Message updateActivos(Activo_Fijo a){
			
			verificarDatos verificar= new verificarDatos();
			compararFechas cf= new compararFechas();
			if(verificar.activosVerificarDatosFaltantes(a)){
				if(cf.verificarFecha(a)){
					activosBean activosbean=new activosBean();
					activosbean.updateActivos(a);
					Message message = new Message(200, "Operacion exitosa");
					return message;
				}else{
					Message message = new Message(400, cf.getMessage());
					Response reponse = Response.status(400).entity(message).build();
					throw new WebApplicationException(reponse);
				}
			}else{
				//faltan de datos
				Message message = new Message(400, "Faltan datos: "+ verificar.getDatoQueFalta());
				Response reponse = Response.status(400).entity(message).build();
				throw new WebApplicationException(reponse);
			}
		
	}

	

}