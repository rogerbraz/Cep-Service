package br.com.correios.cep;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.com.correios.cep.dto.EnderecoDTO;

@RestController
@RequestMapping("/endereco")
public class CepController {

	@Autowired
	public CepService cepservice;
	@Autowired
	public EnderecoRepository enderecoRepository;

	@GetMapping
	@Transactional
	public ResponseEntity<Page<Endereco>> buscaCep(@PathVariable(required = false) Long id, Pageable paginacao) {
		return cepservice.buscaCep(id, paginacao);	}

	@PostMapping()
	@Transactional
	public ResponseEntity<Endereco> cadastrar(@RequestBody @Valid EnderecoDTO dto,
			UriComponentsBuilder uriBuilder) {
		return cepservice.cadastrar(dto, uriBuilder);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id,
			@RequestBody @Valid EnderecoDTO dto) {
		return cepservice.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return cepservice.remover(id);
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<Page<Endereco>> buscarId(
			@PathVariable Long id, Pageable paginacao){
		return ResponseEntity.ok(cepservice.buscarId(id, paginacao));
	}
}
