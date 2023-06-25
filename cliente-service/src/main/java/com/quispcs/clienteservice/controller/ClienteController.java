package com.quispcs.clienteservice.controller;

import com.quispcs.clienteservice.entity.Cliente;
import com.quispcs.clienteservice.service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    @GetMapping()
    public List<Cliente> listar() {
        return clienteService.listar();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") long id) {
        log.info("Obtener cliente por id {}", id);
        Cliente cliente = clienteService.getCliente(id);
        if (  null == cliente) {
            log.error("cliente con id {} no encontrado.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(cliente);
    }
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
        log.info("Creando Cliente : {}", cliente);

        Cliente clienteDB = clienteService.createCliente (cliente);

        return  ResponseEntity.status( HttpStatus.CREATED).body(clienteDB);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @RequestBody Cliente cliente) {
        log.info("editando cliente con id {}", id);

        Cliente currentCliente = clienteService.getCliente(id);

        if ( null == currentCliente ) {
            log.error("cliente con id {} no encontrado.", id);
            return  ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        currentCliente=clienteService.updateCliente(cliente);
        return  ResponseEntity.ok(currentCliente);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") long id) {
        log.info("Eliminando cliente con id: {}", id);

        Cliente cliente = clienteService.getCliente(id);
        if ( null == cliente ) {
            log.error("no se pudo eliminar, cliente con id {} no encontrado", id);
            return  ResponseEntity.notFound().build();
        }
        cliente = clienteService.deleteCliente(cliente);
        return  ResponseEntity.ok(cliente);
    }

}
