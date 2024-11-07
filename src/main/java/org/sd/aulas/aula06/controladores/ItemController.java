package org.sd.aulas.aula06.controladores;

import org.sd.aulas.aula06.entidades.Item;
import org.sd.aulas.aula06.repositorios.ItemRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepositoryJPA repositoryJPA;

    @GetMapping(value = "/{id}")
    public Item get(@PathVariable(name = "id") Long id) {
        Item item = repositoryJPA.findById(id).orElse(null);
        return  item;
    }

    @GetMapping
    public List<Item> findAll() {
        List<Item> items = repositoryJPA.findAll();
        return items;
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        item = repositoryJPA.save(item);
        return item;
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestBody Item item) {

        item.setId(id);
        item = repositoryJPA.save(item);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {
        repositoryJPA.deleteById(id);
    }
}
