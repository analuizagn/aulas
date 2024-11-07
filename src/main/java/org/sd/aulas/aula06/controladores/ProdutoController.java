package org.sd.aulas.aula06.controladores;

import org.sd.aulas.aula06.entidades.Produto;
import org.sd.aulas.aula06.repositorios.ProdutoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepositoryJPA repositoryJPA;

    @GetMapping(value = "/{id}")
    public Produto get(@PathVariable(name = "id") Long id) {
        Produto produto = repositoryJPA.findById(id).orElse(null);
        return  produto;
    }

    @GetMapping
    public List<Produto> findAll() {
        List<Produto> produtos = repositoryJPA.findAll();
        return produtos;
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        produto = repositoryJPA.save(produto);
        return produto;
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestBody Produto produto) {

        produto.setId(id);
        produto = repositoryJPA.save(produto);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {
        repositoryJPA.deleteById(id);
    }
}
