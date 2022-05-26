package br.com.correios.cep.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.correios.cep.model.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

	private Long id;
	private String cep;
	private String Logradouro;
	private String Bairro;
	private String Cidade;

	public EnderecoDTO() {

	}

	public EnderecoDTO(Endereco endereco) {
		this.id = endereco.getId();
		this.cep = endereco.getCep();
		this.Logradouro = endereco.getLogradouro();
		this.Bairro = endereco.getBairro();
		this.Cidade = endereco.getCidade();
	}

	public static List<EnderecoDTO> converter(Optional<Endereco> findByIdt) {
		return findByIdt.stream().map(EnderecoDTO::new).collect(Collectors.toList());
	}

	public static List<EnderecoDTO> converter(List<Endereco> findAll) {
		return findAll.stream().map(EnderecoDTO::new).collect(Collectors.toList());
	}


}