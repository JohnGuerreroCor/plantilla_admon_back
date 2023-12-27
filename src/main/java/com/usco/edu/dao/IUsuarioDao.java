package com.usco.edu.dao;

import com.usco.edu.entities.Usuario;

public interface IUsuarioDao { 
	
	public Usuario buscarUsuario(String usuario);
	
	public boolean validarUsuario(String usuario);

}
