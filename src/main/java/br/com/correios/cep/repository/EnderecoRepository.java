package br.com.correios.cep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.correios.cep.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long>{
	
	List<Endereco> findByCep(String cep);

	List<Endereco> findById(String id);

}
