package br.com.correios.cep.controller.dto;

import java.util.Optional;

import org.springframework.data.domain.Page;

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

	public static Page<EnderecoDTO> converter(Page<Endereco> endereco) {
		return endereco.map(EnderecoDTO::new);
	}

	public static Page<EnderecoDTO> converter(Optional<Endereco> findById) {
		// TODO Auto-generated method stub
		return null;
	}


}