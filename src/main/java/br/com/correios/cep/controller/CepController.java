package br.com.correios.cep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.correios.cep.controller.dto.EnderecoDTO;
import br.com.correios.cep.service.CepService;

@RestController
@RequestMapping("/endereco")
public class CepController {

	@Autowired
	public CepService cepservice;

	@GetMapping("/{cep}")
	public List<EnderecoDTO> buscaCep(@PathVariable(required = false) String cep) {
			return cepservice.buscaCep(cep);
	}
	
	@GetMapping()
	public List<EnderecoDTO> buscaCep() {
			return cepservice.buscaCep(null);
	}

}
