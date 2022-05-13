package br.com.correios.cep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.correios.cep.controller.dto.EnderecoDTO;
import br.com.correios.cep.repository.EnderecoRepository;

@Service
public class CepService {
	
	@Autowired
	public EnderecoRepository endereco;
	
	public List<EnderecoDTO> buscaCep(String cep) {
		if(cep !=null) {
			return EnderecoDTO.converter(endereco.findByCep(cep));		
		}
		return	EnderecoDTO.converter(endereco.findAll());
	}
}
