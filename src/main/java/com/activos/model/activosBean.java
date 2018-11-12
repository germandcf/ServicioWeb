package com.activos.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import com.activos.entidades.Activo_Fijo;
import com.activos.entidades.Area;
import com.activos.entidades.Persona;
import com.activos.util.HibernateUtil;
import com.activos.ws.Message;



/**
 * Session Bean implementation class activosBean
 */
@Stateless
@LocalBean
public class activosBean {

    /**
     * Default constructor. 
     */
    public activosBean() {
        // TODO Auto-generated constructor stub
    }

    
    @SuppressWarnings("unchecked")
    public List<Activo_Fijo> getActivoFijoAll(){
	    try{
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
			List<Activo_Fijo> Activos = (List<Activo_Fijo>) session.createQuery("FROM Activo_Fijo").list();
			
			System.out.println(Activos.size());
			
			return Activos;
			
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    	Message message = new Message(500, "Error en la capa de backend");
			Response reponse = Response.status(500).entity(message).build();
			throw new WebApplicationException(reponse);
		}
	    
		
    }
    
    @SuppressWarnings("unchecked")
    public List<Activo_Fijo> getActivoByType(String tipo){
    	try{
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
			List<Activo_Fijo> Activos = (List<Activo_Fijo>) session.createQuery("FROM Activo_Fijo WHERE tipo= '"+tipo+"'").list();
			
			System.out.println(Activos.size());
			
			return Activos;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		Message message = new Message(500, "Error en la capa de backend");
    		Response reponse = Response.status(500).entity(message).build();
    		throw new WebApplicationException(reponse);
    	}
		
    }
    
    @SuppressWarnings("unchecked")
    public List<Activo_Fijo> getActivosBySerial(String serial){
	    try{
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
			List<Activo_Fijo> Activos = (List<Activo_Fijo>) session.createQuery("FROM Activo_Fijo WHERE serial= '"+serial+"'").list();
			
			System.out.println(Activos.size());
			
			return Activos;
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    	
	    	Message message = new Message(500, "Error en la capa de backend");
			Response reponse = Response.status(500).entity(message).build();
			throw new WebApplicationException(reponse);
		}
		
    }
    
    @SuppressWarnings("unchecked")
    public List<Activo_Fijo> getActivosByFechaCompra(String fecha){
    try{
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
		List<Activo_Fijo> Activos = (List<Activo_Fijo>) session.createQuery("FROM Activo_Fijo WHERE Fecha_Compra= '"+fecha+"'").list();
		
		System.out.println(Activos.size());
		
		return Activos;
    }catch(Exception ex){
    	ex.printStackTrace();
    	
    	Message message = new Message(500, "Error en la capa de backend");
		Response reponse = Response.status(500).entity(message).build();
		throw new WebApplicationException(reponse);
	}
	
    }
    
    @SuppressWarnings("unchecked")
    public List<Area> getAreaAll(){
	    try{
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
			List<Area> Areas = (List<Area>) session.createQuery("FROM Area").list();
			
			System.out.println(Areas.size());
			
			return Areas;
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    	Message message = new Message(500, "Error en la capa de backend");
			Response reponse = Response.status(500).entity(message).build();
			throw new WebApplicationException(reponse);
		}
		
    }
    
    @SuppressWarnings("unchecked")
    public List<Persona> getPersonaAll(){
	    try{
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	    	session.beginTransaction();
			List<Persona> Personas = (List<Persona>) session.createQuery("FROM Persona").list();
			
			System.out.println(Personas.size());
			
			return Personas;
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    	Message message = new Message(500, "Error en la capa de backend");
			Response reponse = Response.status(500).entity(message).build();
			throw new WebApplicationException(reponse);
		}
		
    }
    
    
    public void addActivos(Activo_Fijo a){
	    try{
	    	Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(a);
			session.getTransaction().commit();
			session.close();
		}catch(Exception ex){
			ex.printStackTrace();
			Message message = new Message(500, "Error en la capa de backend");
			Response reponse = Response.status(500).entity(message).build();
			throw new WebApplicationException(reponse);
		}

    }
    
	public void updateActivos(Activo_Fijo a){
		try{	
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.update(a);
			session.getTransaction().commit();
			session.close();
		}catch(Exception ex){
			ex.printStackTrace();
			Message message = new Message(500, "Error en la capa de backend");
			Response reponse = Response.status(500).entity(message).build();
			throw new WebApplicationException(reponse);
		}
    }
    
}