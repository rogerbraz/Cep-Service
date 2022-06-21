package br.com.correios.pessoa.dto;

import javax.persistence.ManyToOne;

import br.com.correios.cep.Endereco;
import br.com.correios.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class PessoaDTO {

	private String nome;
	private String documento;
	@ManyToOne
	private Endereco endereco;
	private String telefone;

	public PessoaDTO(Pessoa pessoa) {
		this.nome=pessoa.getNome();
		this.documento=pessoa.getDocumento();
		this.endereco=pessoa.getEndereco();
		this.telefone=pessoa.getTelefone();
	}

}