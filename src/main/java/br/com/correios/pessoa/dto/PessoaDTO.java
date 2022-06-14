package br.com.correios.pessoa.dto;

import br.com.correios.cep.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class PessoaDTO {

	private Long id;
	private String nome;
	private String documento;
	private Endereco endereco1;
	private Endereco endereco2;
	private String telefone;


}