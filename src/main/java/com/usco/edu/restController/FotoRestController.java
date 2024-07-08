package com.usco.edu.restController;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.dto.Foto;
import com.usco.edu.service.IFotoService;

@RestController
@RequestMapping(path = "foto")
public class FotoRestController {
	
	@Autowired
	IFotoService service;
	
    // ENDPOINT PARA OBTENER FOTO
	@GetMapping("obtener-foto/{user}/{codigo}")
	public ResponseEntity<InputStreamResource> foto(@PathVariable String user, HttpServletResponse response, @PathVariable String codigo) throws Exception{
		ByteArrayInputStream stream = service.mirarFoto(codigo, user, response);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=\" foto.png\"");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
		
	}
	
    // ENDPOINT PARA OBTENER FOTO ANTIGUA
	@GetMapping(path = "obtener-foto-antigua/{user}/{codigo}")
	public Foto fotoAntigua(@PathVariable String user, @PathVariable String codigo) throws Exception{
		return service.mirarFotoAntigua(codigo, user);
	}
}
