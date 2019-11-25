/**
 * 
 */
package com.api.agencias.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.api.agencias.models.entity.Agencia;
import com.api.agencias.models.service.AgenciaService;

/**
 * @author CESAR
 *
 */
@RestController
@RequestMapping(value = "/v0")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AgenciaController {
	
	@Autowired
	private AgenciaService agenciaService;
	
	@GetMapping(value = "/agencias")
	public ResponseEntity<?> listarAgenciasBcp(){
		return new ResponseEntity<List<Agencia>>(agenciaService.listarAgencias(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/agencias/{id-agencia}")
	public ResponseEntity<?> obtenerDatosAgenciaBcpPorId(@PathVariable("id-agencia") Long idAgencia){
		return new ResponseEntity<Agencia>(agenciaService.consultarAgenciaPorId(idAgencia),HttpStatus.OK); 
	}
	
	@GetMapping(value = "/agencias/filtro")
	public ResponseEntity<?> listarAgenciasBcpPorNombre(@RequestParam(name="nombre") String nombreAgencia){
		return new ResponseEntity<List<Agencia>>(agenciaService.consultarAgenciaPorNombre(nombreAgencia), HttpStatus.OK);
	}
	
	@PostMapping(value = "/agencias" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> Agencia(@Valid @RequestBody Agencia agencia){
		 return new ResponseEntity<Agencia>(agenciaService.grabarAgencia(agencia), HttpStatus.CREATED);
	}
	
}
