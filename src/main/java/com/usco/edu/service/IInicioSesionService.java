package com.usco.edu.service;

public interface IInicioSesionService {
	
	public String getTokenInicioSesion(String atributos , String userdb);
	
	public String urltokenPeticion( String userdb);

}
