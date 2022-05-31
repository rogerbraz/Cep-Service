package br.com.correios.cep.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.correios.cep.controller.dto.AtualizarEnderecoForm;
import br.com.correios.cep.controller.dto.EnderecoDTO;
import br.com.correios.cep.controller.dto.EnderecoForm;
import br.com.correios.cep.repository.EnderecoRepository;
import br.com.correios.cep.service.CepService;

@RestController
@RequestMapping("/endereco")
public class CepController {

	@Autowired
	public CepService cepservice;
	@Autowired
	public EnderecoRepository enderecoRepository;

	@GetMapping
	@Transactional
	public Page<EnderecoDTO> buscaCep(@PathVariable(required = false) Long id, int pagina, int qtd, String ordenacao) {

		return cepservice.buscaCep(id, pagina, qtd, ordenacao);
	}

	@PostMapping()
	@Transactional
	public ResponseEntity<EnderecoDTO> cadastrar(@RequestBody @Valid EnderecoForm form,
			UriComponentsBuilder uriBuilder) {
		return cepservice.cadastrar(form, uriBuilder);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EnderecoDTO> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizarEnderecoForm form) {
		return cepservice.atualizar(id, form);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return cepservice.remover(id);
	}

}
