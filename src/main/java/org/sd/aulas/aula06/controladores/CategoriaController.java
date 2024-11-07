package org.sd.aulas.aula06.controladores;

import org.sd.aulas.aula06.entidades.Categoria;
import org.sd.aulas.aula06.servicos.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public Categoria get(@PathVariable(name = "id") Long id) {
        Categoria categoria = service.get(id);
        return  categoria;
    }

    @GetMapping
    public List<Categoria> findAll() {
        List<Categoria> categorias = service.findAll();
        return categorias;
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        categoria = service.create(categoria);
        return categoria;
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestBody Categoria categoria) {

        categoria.setId(id);
        categoria = service.update(categoria);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {
        service.remove(id);
    }
}
