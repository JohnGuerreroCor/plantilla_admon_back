package com.usco.edu.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IInicioSesionDao;

@Repository
public class InicioSesionDaoImpl  implements IInicioSesionDao{

	@Autowired
	@Qualifier("JDBCTemplateUscoConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public String getTokenInicioSesion(String atributos, String userdb) {	
		
		String token = null;
		try {
			token = jdbcTemplate.queryForObject("SELECT token.getTokenInicioSesion(?)", new Object[] { atributos }, String.class);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return token;

	}

	@Override
	public String urltokenPeticion( String userdb) {
		
		String url = null;
		try {
			//URL DEL MODULO DE AUTENTICACION APLICATIVOS - TOKEN
			url = jdbcTemplate.queryForObject("SELECT wep_valor FROM dbo.web_parametro wp where wp.wep_codigo = 377" , String.class);
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return url;

	}
	
	@Override
	public String obtenerSegundaClaveReal( String segundaClave) {
		String sql ="SELECT dbo.encriptarClaveReal(?) as clave";
		String claveReal = jdbcTemplate.queryForObject(sql, new Object[] {segundaClave }, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("clave");
			}
			
		});
		 return claveReal;
	}

}
