package br.com.correios.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroDeFormularioDTO {
	
	String erro;
	String mensagem;
	
	
	public ErroDeFormularioDTO(String erro, String mensagem) {
		this.erro = erro;
		this.mensagem = mensagem;
	}
	public ErroDeFormularioDTO() {
	}

	
}
