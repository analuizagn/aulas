package org.sd.aulas.aula06.repositorios;

import org.sd.aulas.aula06.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryJPA extends JpaRepository<Cliente, Long> {

    @Query("select cli from Cliente cli where cli.cpf = ?1")
    public Cliente findByCpf(String cpf);
}
