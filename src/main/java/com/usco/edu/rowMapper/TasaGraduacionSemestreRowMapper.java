package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.TasaGraduacionSemestre;

public class TasaGraduacionSemestreRowMapper implements RowMapper<TasaGraduacionSemestre> {
	
	@Override
	public TasaGraduacionSemestre mapRow(ResultSet rs, int rowNum) throws SQLException {
		TasaGraduacionSemestre tasaGraduacionSemestre = new TasaGraduacionSemestre();
		tasaGraduacionSemestre.setSemestre(rs.getInt("paa_semestre"));
		return tasaGraduacionSemestre;
		
	}
}
