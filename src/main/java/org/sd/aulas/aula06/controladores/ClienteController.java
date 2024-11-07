package org.sd.aulas.aula06.controladores;

import org.sd.aulas.aula06.entidades.Cliente;
import org.sd.aulas.aula06.repositorios.ClienteRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepositoryJPA repositoryJPA;

    @GetMapping(value = "/{id}")
    public Cliente get(@PathVariable(name = "id") Long id) {
        Cliente cliente = repositoryJPA.findById(id).orElse(null);
        return  cliente;
    }

    @GetMapping
    public List<Cliente> findAll() {
        List<Cliente> clientes = repositoryJPA.findAll();
        return clientes;
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        cliente = repositoryJPA.save(cliente);
        return cliente;
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestBody Cliente cliente) {

        cliente.setId(id);
        cliente = repositoryJPA.save(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {
        repositoryJPA.deleteById(id);
    }
}
