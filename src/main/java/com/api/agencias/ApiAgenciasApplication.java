package com.api.agencias;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.api.agencias.models.repository.AgenciaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.api.agencias.models.entity.Agencia;


@SpringBootApplication
public class ApiAgenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAgenciasApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(AgenciaRepository agenciaRepository){
	    return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Agencia>> typeReference = new TypeReference<List<Agencia>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/agencias.json");
			try {
				List<Agencia> listaAgenciasInicial = mapper.readValue(inputStream,typeReference);
				agenciaRepository.saveAll(listaAgenciasInicial);
			} catch (IOException e){
				System.out.println("No ha sido posible cargar archivo agencias.json " + e.getMessage());
			}
	    };
	}

}
