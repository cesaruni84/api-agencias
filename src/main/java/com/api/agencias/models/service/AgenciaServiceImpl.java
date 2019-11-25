/**
 * 
 */
package com.api.agencias.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.agencias.models.entity.Agencia;
import com.api.agencias.models.repository.AgenciaRepository;

/**
 * @author CESAR
 *
 */

@Service
public class AgenciaServiceImpl implements AgenciaService{
	
	@Autowired
	private AgenciaRepository agenciaRepository;

	@Override
	public List<Agencia> listarAgencias() {
		return this.agenciaRepository.findAll();
	}

	@Override
	public List<Agencia> consultarAgenciaPorNombre(String nombre) {
		return this.agenciaRepository.findByName(nombre);
	}

	@Override
	public Agencia consultarAgenciaPorId(Long id) {
		return this.agenciaRepository.findById(id).orElse(null);
	}

	@Override
	public Agencia grabarAgencia(Agencia agencia) {
		return this.agenciaRepository.save(agencia);
	}

}
