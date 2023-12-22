package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.TasaGraduacionPeriodo;
import com.usco.edu.entities.TasaGraduacionPersonas;
import com.usco.edu.entities.TasaGraduacionSemestre;

public interface ITasaGraduacionService {
	
	public List<TasaGraduacionPeriodo> obtenerPeriodosMatriculados(int programaCodigo);
	
	public List<TasaGraduacionSemestre> obtenerSemestresPrograma(int programaCodigo);
	
	public List<TasaGraduacionPersonas> obtenerEstudiantesPrimerIngreso(String periodoInicial, String periodoFinal, int programaCodigo);
	
	public List<TasaGraduacionPersonas> obtenerGraduados(int programaCodigo, String periodo);

}
