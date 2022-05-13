package br.com.correios.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.correios.cep.model.Endereco;
import br.com.correios.cep.service.CepService;

@RestController
@RequestMapping("/buscacep")
public class CepController {
	
	@Autowired
	public CepService cepservice;
	
	@RequestMapping ("/{cep}")
	public Endereco buscaCep(@PathVariable("cep") String cep) {
		
		
	return 	cepservice.buscaCep(cep);
		
	}
	
}
