package com.activos.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Persona")
public class Persona implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private int Id_persona;
	
	@Column
	private String Tipo_Identificacion;
	
	@Column
	private String Numero_Identificacion;
	
	@Column
	private String Nombres;
	
	@Column
	private String Apellidos;
	
	@Column
	private String Telefono;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="Persona")
	private List<Activo_Fijo> Activos;
		
	public int getId_persona() 
	{
		return Id_persona;
	}
	public void setId_persona(int id_persona) 
	{
		Id_persona = id_persona;
	}
	public String getTipo_Identificacion() 
	{
		return Tipo_Identificacion;
	}
	public void setTipo_Identificacion(String tipo_Identificacion) 
	{
		Tipo_Identificacion = tipo_Identificacion;
	}
	public String getNumero_Identificacion() 
	{
		return Numero_Identificacion;
	}
	public void setNumero_Identificacion(String numero_Identificacion) 
	{
		Numero_Identificacion = numero_Identificacion;
	}
	public String getNombres() 
	{
		return Nombres;
	}
	public void setNombres(String nombres) 
	{
		Nombres = nombres;
	}
	public String getApellidos() 
	{
		return Apellidos;
	}
	public void setApellidos(String apellidos) 
	{
		Apellidos = apellidos;
	}
	public String getTelefono() 
	{
		return Telefono;
	}
	public void setTelefono(String telefono) 
	{
		Telefono = telefono;
	}
}