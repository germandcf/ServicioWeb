package com.activos.entidades;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Activo_Fijo")
public class Activo_Fijo implements Serializable 
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Id_Activo")
	private int		Id_Activo;
    
	@Column
	private String	Nombre;
    
	@Column
	private String  Descripcion;
    
	@Column
	private String  Tipo;
    
	@Column
	private String	Serial;
    
	@Column
	private int 	NII;
    
	@Column
	private double	Peso;
    
	@Column
	private double	Alto;
    
	@Column
	private double	Ancho;
    
	@Column
	private double	Largo;
    
	@Column
	private double	Valor_Compra;
    
	@Column
	private	Date	Fecha_Compra;
    
	@Column
	private Date	Fecha_Baja;
    
	@Column
	private int		Estado_Activo;
    
	@Column
	private String	Color;
    
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Id_Area")
	private Area Area;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Id_Persona")
    private Persona Persona;
    
	public int getId_Activo() 
	{
		return Id_Activo;
	}
	public void setId_Activo(int id_Activo) 
	{
		Id_Activo = id_Activo;
	}
	public String getNombre() 
	{
		return Nombre;
	}
	public void setNombre(String nombre) 
	{
		Nombre = nombre;
	}
	public String getDescripcion() 
	{
		return Descripcion;
	}
	public void setDescripcion(String descripcion) 
	{
		Descripcion = descripcion;
	}
	public String getTipo() 
	{
		return Tipo;
	}
	public void setTipo(String tipo) 
	{
		Tipo = tipo;
	}
	public String getSerial() 
	{
		return Serial;
	}
	public void setSerial(String serial) 
	{
		Serial = serial;
	}
	public int getNII() 
	{
		return NII;
	}
	public void setNII(int nII) 
	{
		NII = nII;
	}
	public double getPeso() 
	{
		return Peso;
	}
	public void setPeso(double peso) 
	{
		Peso = peso;
	}
	public double getAlto() 
	{
		return Alto;
	}
	public void setAlto(double alto) 
	{
		Alto = alto;
	}
	public double getAncho() 
	{
		return Ancho;
	}
	public void setAncho(double ancho) 
	{
		Ancho = ancho;
	}
	public double getLargo() 
	{
		return Largo;
	}
	public void setLargo(double largo) 
	{
		Largo = largo;
	}
	public double getValor_Compra() 
	{
		return Valor_Compra;
	}
	public void setValor_Compra(double valor_Compra) 
	{
		Valor_Compra = valor_Compra;
	}
	public Date getFecha_Compra() 
	{
		return Fecha_Compra;
	}
	public void setFecha_Compra(Date fecha_Compra) 
	{
		Fecha_Compra = fecha_Compra;
	}
	public Date getFecha_Baja() 
	{
		return Fecha_Baja;
	}
	public void setFecha_Baja(Date fecha_Baja) 
	{
		Fecha_Baja = fecha_Baja;
	}
	public int getEstado_Activo() 
	{
		return Estado_Activo;
	}
	public void setEstado_Activo(int estado_Activo) 
	{
		Estado_Activo = estado_Activo;
	}
	public String getColor() 
	{
		return Color;
	}
	public void setColor(String color) 
	{
		Color = color;
	}
	public Area getArea() {
		return Area;
	}
	public void setArea(Area area) 
	{
		Area = area;
	}
	public Persona getPersona() 
	{
		return Persona;
	}
	public void setPersona(Persona persona) 
	{
		Persona = persona;
	}
}