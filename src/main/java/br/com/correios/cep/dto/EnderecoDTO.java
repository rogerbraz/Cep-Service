package br.com.correios.cep.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTO {

	private Long id;
	private String cep;
	private String Logradouro;
	private String Bairro;
	private String Cidade;
}