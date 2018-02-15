package br.com.pdv.repository;

import br.com.pdv.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
