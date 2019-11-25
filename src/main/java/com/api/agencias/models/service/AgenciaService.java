package com.api.agencias.models.service;

import java.util.List;
import com.api.agencias.models.entity.Agencia;

public interface AgenciaService {
	
	List<Agencia> listarAgencias();
	List<Agencia> consultarAgenciaPorNombre(String nombre);
	Agencia consultarAgenciaPorId(Long id);
	Agencia grabarAgencia(Agencia agencia);

}
