package br.com.correios.pessoa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa, Long>{

	Page<Pessoa> findById(Long id, Pageable paginacao);

}
