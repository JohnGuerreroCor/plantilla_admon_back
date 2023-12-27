package com.usco.edu.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IInicioSesionDao;
import com.usco.edu.service.IInicioSesionService;

@Service
public class InicioSesionServiceImpl implements IInicioSesionService {
	
	@Autowired
	private IInicioSesionDao inicioSesionDao;

	@Override
	public String getTokenInicioSesion(String atributos, String userdb) {
		return inicioSesionDao.getTokenInicioSesion(atributos, userdb);
	}

	@Override
	public String urltokenPeticion(String userdb) {
		return inicioSesionDao.urltokenPeticion(userdb);
	}
}
