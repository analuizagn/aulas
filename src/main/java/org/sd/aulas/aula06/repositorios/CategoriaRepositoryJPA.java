package org.sd.aulas.aula06.repositorios;

import org.sd.aulas.aula06.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositoryJPA extends JpaRepository<Categoria, Long> {

}
