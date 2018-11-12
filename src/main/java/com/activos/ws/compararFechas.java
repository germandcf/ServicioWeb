package com.activos.ws;

import com.activos.entidades.Activo_Fijo;

public class compararFechas {
	
	private String message;
	
	public compararFechas(){
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean verificarFecha(Activo_Fijo a){
		
		boolean rs = true;
		if(a.getFecha_Compra()!=null && a.getFecha_Baja()!=null) {
			if(a.getFecha_Compra().compareTo(a.getFecha_Baja())== 1){
				this.message="la fecha de compra es mas recientes que la fecha de debaja";
				rs= false;
			}
		}	
	   return rs;
		
	   
	}
}
