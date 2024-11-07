package org.sd.aulas.aula06.controladores;

import org.sd.aulas.aula06.entidades.Pedido;
import org.sd.aulas.aula06.repositorios.PedidoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepositoryJPA repositoryJPA;

    @GetMapping(value = "/{id}")
    public Pedido get(@PathVariable(name = "id") Long id) {
        Pedido pedido = repositoryJPA.findById(id).orElse(null);
        return  pedido;
    }

    @GetMapping
    public List<Pedido> findAll() {
        List<Pedido> pedidos = repositoryJPA.findAll();
        return pedidos;
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        pedido = repositoryJPA.save(pedido);
        return pedido;
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestBody Pedido pedido) {

        pedido.setId(id);
        pedido = repositoryJPA.save(pedido);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable(name = "id") Long id) {
        repositoryJPA.deleteById(id);
    }
}
