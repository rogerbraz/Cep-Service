package br.com.correios.cep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.correios.cep.model.Endereco;
import br.com.correios.cep.repository.EnderecoRepository;

@Service
public class CepService {
	
	@Autowired
	public EnderecoRepository endereco;
	
	public Endereco buscaCep(String cep) {
	
		return	endereco.findByCep(cep);
		
		
	}

}
