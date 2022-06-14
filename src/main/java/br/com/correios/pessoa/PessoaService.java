package br.com.correios.pessoa;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.correios.pessoa.dto.PessoaDTO;


@Service
public class PessoaService {

	@Autowired
	public PessoaRepository pessoaRepository;

	public ResponseEntity<Pessoa> cadastrar(@RequestBody(required = true) PessoaDTO dto,
			UriComponentsBuilder uriBuilder) {
		
		Pessoa pessoa = pessoaRepository.save(Pessoa.builder()
				.nome(dto.getNome())
				.documento(dto.getDocumento())
				.endereco1(dto.getEndereco1())
				.endereco2(dto.getEndereco2())
				.telefone(dto.getTelefone())
				.build());

		URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(pessoa.getId()).toUri();

		return ResponseEntity.created(uri).body(pessoa);
	}

	public ResponseEntity<Pessoa> atualizar(@PathVariable(required = true) Long id,
			@RequestBody(required = true) PessoaDTO dto) {
		Pessoa pessoa = pessoaRepository.save(Pessoa.builder()
				.nome(dto.getNome())
				.documento(dto.getDocumento())
				.endereco1(dto.getEndereco1())
				.endereco2(dto.getEndereco2())
				.telefone(dto.getTelefone()).build());
		
		return ResponseEntity.ok(pessoa);
	}

	public ResponseEntity<?> remover(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Page<Pessoa>> buscaPessoa(Long id, Pageable paginacao) {
		if (id != null) {
			Page<Pessoa> pessoa = pessoaRepository.findById(id, paginacao);
			return ResponseEntity.ok(pessoa);
		}
		return ResponseEntity.notFound().build();
	}

	public List<Pessoa> buscarId(Long id) {
		return pessoaRepository.findPessoaById(id);
	}

}
