package br.com.correios.cep;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.correios.cep.dto.EnderecoDTO;

@Service
public class CepService {

	@Autowired
	public EnderecoRepository enderecoRepository;	

	public ResponseEntity<Endereco> cadastrar(@RequestBody @Valid EnderecoDTO dto,
			UriComponentsBuilder uriBuilder) {
		
		Endereco endereco = enderecoRepository.save(Endereco.builder()
				.cep(dto.getCep())
				.logradouro(dto.getLogradouro())
				.bairro(dto.getBairro())
				.cidade(dto.getCidade())
				.build()
				);
		URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();

		return ResponseEntity.created(uri).body(endereco);
	}

	public ResponseEntity<EnderecoDTO> atualizar(@PathVariable Long id, @Valid EnderecoDTO dto) {
		Endereco endereco = enderecoRepository.save(Endereco.builder()
				.cep(dto.getCep())
				.logradouro(dto.getLogradouro())
				.bairro(dto.getBairro())
				.cidade(dto.getCidade())
				.build()
				);
		return ResponseEntity.ok(new EnderecoDTO(endereco));
	}

	public ResponseEntity<?> remover(@PathVariable Long id) {
		enderecoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	public Page<EnderecoDTO> buscaCep(Long id, Pageable paginacao) {
		if (id != null) {
			Page<Endereco> endereco = enderecoRepository.findById(id, paginacao);
			return EnderecoDTO.converter(endereco);
		}
		return EnderecoDTO.converter(enderecoRepository.findAll(paginacao));
	}
	
	public List<Endereco> buscarId(Long id){
		return enderecoRepository.findEnderecoById(id);
	}
	

}
