package br.com.correios.cep.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.correios.cep.model.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

	private String cep;
	private String Logradouro;
	private String Bairro;
	private String Cidade;

	public EnderecoDTO() {

	}

	public EnderecoDTO(Endereco endereco) {
		this.cep = endereco.getCep();
		this.Logradouro = endereco.getLogradouro();
		this.Bairro = endereco.getBairro();
		this.Cidade = endereco.getCidade();
	}

	public static List<EnderecoDTO> converter(List<Endereco> endereco) {
		return endereco.stream().map(EnderecoDTO::new).collect(Collectors.toList());
	}
}