package br.com.correios.cep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.correios.cep.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, String>{
	
	Endereco findByCep(String cep);

}
