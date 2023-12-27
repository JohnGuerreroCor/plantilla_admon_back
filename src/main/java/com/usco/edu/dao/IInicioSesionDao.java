package com.usco.edu.dao;

public interface IInicioSesionDao {
	
	public String getTokenInicioSesion(String atributos, String userdb);
	
	public String urltokenPeticion( String userdb);
	
	public String obtenerSegundaClaveReal(String segundaClave);

}
