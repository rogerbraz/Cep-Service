package br.com.correios.pessoa;

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

import br.com.correios.pessoa.dto.PessoaDTO;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	public PessoaService pessoaservice;
	@Autowired
	public PessoaRepository pessoaRepository;

	@GetMapping
	@Transactional
	public ResponseEntity<Page<Pessoa>> buscaPage(@PathVariable(required = false) Long id, Pageable paginacao) {

		return pessoaservice.buscaPessoa(id, paginacao);
	}

	@PostMapping()
	@Transactional
	public ResponseEntity<Pessoa> cadastrar(@RequestBody(required = true) @Valid PessoaDTO dto,
			UriComponentsBuilder uriBuilder) {
		return pessoaservice.cadastrar(dto, uriBuilder);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Pessoa> atualizar(@PathVariable(required = true) Long id,
			@RequestBody(required = true) @Valid PessoaDTO dto) {
		return pessoaservice.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return pessoaservice.remover(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Pessoa>> buscarId(@PathVariable Long id) {
		return ResponseEntity.ok(pessoaservice.buscarId(id));
	}
}
