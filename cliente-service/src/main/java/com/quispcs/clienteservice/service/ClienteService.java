package com.quispcs.clienteservice.service;

import com.quispcs.clienteservice.entity.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> listar();
    public Cliente createCliente(Cliente customer);
    public Cliente updateCliente(Cliente customer);
    public Cliente deleteCliente(Cliente customer);
    public  Cliente getCliente(Long id);
}
