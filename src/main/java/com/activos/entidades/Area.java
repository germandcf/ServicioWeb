package com.activos.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name="Area")
public class Area implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	private int Id_Area;
	
	@Column
	private String Nombre;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="Area")
	private List<Activo_Fijo> Activos;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Id_Ciudad")
    private Ciudad Ciudad;
	
	public int getId_Area() 
	{
		return Id_Area;
	}
	public void setId_Area(int id_Area) 
	{
		Id_Area = id_Area;
	}
	public String getNombre() 
	{
		return Nombre;
	}
	public void setNombre(String nombre) 
	{
		Nombre = nombre;
	}
	public Ciudad getCiudad() {
		return Ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		Ciudad = ciudad;
	}

	
}