package br.com.correios.cep.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.correios.cep.model.Endereco;
import br.com.correios.cep.repository.EnderecoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoForm {

	@NotEmpty
	@NotNull
	@Length(min = 8 , max = 8 )
	private String cep;
	@NotEmpty
	@NotNull
	private String logradouro;
	@NotEmpty
	@NotNull
	private String bairro;
	@NotEmpty
	@NotNull
	private String cidade;
	@NotEmpty
	@NotNull
	private String estado;

	public Endereco converter(EnderecoRepository enderecoRepository) {
		return new Endereco(cep, logradouro, bairro, cidade, estado);
	}

}
