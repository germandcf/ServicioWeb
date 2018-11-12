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
@Table(name="Ciudad")
public class Ciudad implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int Id_Ciudad;
	
	@Column
	private String Nombre;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="Ciudad")
	private List<Area> Area;
	
	
	public int getId_Ciudad() 
	{
		return Id_Ciudad;
	}
	public void setId_Ciudad(int id_Ciudad) 
	{
		Id_Ciudad = id_Ciudad;
	}
	public String getNombre() 
	{
		return Nombre;
	}
	public void setNombre(String nombre) 
	{
		Nombre = nombre;
	}
}