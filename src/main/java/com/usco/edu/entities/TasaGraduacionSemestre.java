package com.usco.edu.entities;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TasaGraduacionSemestre implements Serializable  {
	
	private int semestre;
	
	private static final long serialVersionUID = 1L;
}
