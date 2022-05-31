package br.com.correios.cep.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.correios.cep.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long>{

	Page<Endereco> findById(Long id, Pageable paginacao);

}
