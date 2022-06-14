package br.com.correios.cep.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.correios.cep.Endereco;
import br.com.correios.cep.EnderecoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizarEnderecoForm {
	
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
	@Length(min = 2 , max = 2 )
	private String estado;
	
	public Endereco atualizar(Long id, EnderecoRepository enderecoRepository) {
		Endereco endereco = enderecoRepository.getById(id);
		endereco.setCep(this.cep);
		endereco.setLogradouro(this.logradouro);
		endereco.setCidade(this.cidade);
		endereco.setBairro(this.bairro);	
		endereco.setEstado(this.estado);
		return endereco;
	}

}
