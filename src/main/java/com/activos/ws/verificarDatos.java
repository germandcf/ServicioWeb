package com.activos.ws;

import com.activos.entidades.Activo_Fijo;

public class verificarDatos {
	
	private String datoQueFalta;
	
	public verificarDatos(){
		
	}
	
	
	
	public String getDatoQueFalta() {
		return datoQueFalta;
	}



	public void setDatoQueFalta(String datoQueFalta) {
		this.datoQueFalta = datoQueFalta;
	}



	public boolean activosVerificarDatosFaltantes(Activo_Fijo a){
		
		boolean rs=true;
		this.datoQueFalta="";
		
		try{
		
			if(a.getNombre().equals("")){
				this.datoQueFalta=this.datoQueFalta+"nombre, ";
				rs= false;
			}
			
			if(a.getDescripcion().equals("")){
				this.datoQueFalta=this.datoQueFalta+"descripcion,";
				rs= false;
			}
			
			if(a.getTipo().equals("")){
				this.datoQueFalta=this.datoQueFalta+"tipo, ";
				rs= false;
			}
			
			if(a.getSerial().equals("")){
				this.datoQueFalta=this.datoQueFalta+"serial, ";
				rs= false;
			}
			
			if(a.getNII() == 0){
				this.datoQueFalta=this.datoQueFalta+"Numero de inventario";
				rs= false;
			}
		
		   return rs;
		   
		}catch(java.lang.NullPointerException ex){
		
			return false;
			
		}
		
		
	}

}
