package br.com.correios.pessoa;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long>{

	Page<Pessoa> findById(Long id, Pageable paginacao);
	
//	@Query(
//	value = "SELECT * FROM ENDERECO e WHERE e.id = ?1", 
//	nativeQuery = true)
	
	List<Pessoa> findPessoaById(@RequestParam Long id);

}
