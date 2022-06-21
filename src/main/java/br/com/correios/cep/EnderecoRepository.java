package br.com.correios.cep;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long>{

	Page<Endereco> findById(Long id, Pageable paginacao);
	
	@Query(
			value = "SELECT * FROM ENDERECO e WHERE e.id = ?1", 
			nativeQuery = true)
	Page<Endereco> findEnderecoById(@RequestParam Long id, Pageable paginacao);

}
