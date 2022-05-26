package br.com.correios.cep.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.correios.cep.controller.dto.AtualizarEnderecoForm;
import br.com.correios.cep.controller.dto.EnderecoDTO;
import br.com.correios.cep.controller.dto.EnderecoForm;
import br.com.correios.cep.model.Endereco;
import br.com.correios.cep.repository.EnderecoRepository;

@Service
public class CepService {
	
	@Autowired
	public EnderecoRepository enderecoRepository;
	
	public List<EnderecoDTO> buscaCep(@PathVariable Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		if(endereco.isPresent()) {
			return EnderecoDTO.converter(enderecoRepository.findById(id));		
		}
		return	EnderecoDTO.converter(enderecoRepository.findAll());
	}
	
	public ResponseEntity<EnderecoDTO> cadastrar(@RequestBody @Valid EnderecoForm form , UriComponentsBuilder uriBuilder) {
		Endereco endereco = form.converter(enderecoRepository);
		enderecoRepository.save(endereco);
		URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));
	}

	public ResponseEntity<EnderecoDTO> atualizar(@PathVariable Long id, 
			@Valid AtualizarEnderecoForm form) {
		Endereco endereco = form.atualizar(id , enderecoRepository);
		return ResponseEntity.ok(new EnderecoDTO(endereco));
	}
	public ResponseEntity<?> remover(@PathVariable Long id) {
		enderecoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
	
}
