package org.sd.aulas.aula06.repositorios;

import org.sd.aulas.aula06.entidades.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositoryJPA extends JpaRepository<Item, Long> {

}
