package org.sd.aulas.aula06.servicos;

import jakarta.transaction.Transactional;
import org.sd.aulas.aula06.entidades.Categoria;
import org.sd.aulas.aula06.repositorios.CategoriaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepositoryJPA repositoryJPA;

    @Transactional
    public Categoria get(Long id) {
        return repositoryJPA.findById(id).orElse(null);
    }

    @Transactional
    public List<Categoria> findAll() {
        return repositoryJPA.findAll();
    }

    @Transactional
    public Categoria create(Categoria categoria) {
        return repositoryJPA.save(categoria);
    }

    @Transactional
    public Categoria update(Categoria categoria) {
        return repositoryJPA.save(categoria);
    }

    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }
}
