package org.sd.aulas.aula06.repositorios;

import org.sd.aulas.aula06.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositoryJPA extends JpaRepository<Produto, Long> {
}
