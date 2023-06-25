package com.quispcs.clienteservice.service.impl;

import com.quispcs.clienteservice.entity.Cliente;
import com.quispcs.clienteservice.repository.ClienteRepository;
import com.quispcs.clienteservice.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente createCliente(Cliente cliente) {

        Cliente clienteDB = clienteRepository.findBydni(cliente.getDni () );
        if (clienteDB != null){
            return  clienteDB;
        }

        cliente.setEstado("CREATED");
        clienteDB = clienteRepository.save ( cliente );
        return clienteDB;
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        Cliente clienteDB = getCliente(cliente.getId());
        if (clienteDB == null){
            return  null;
        }
        clienteDB.setNombres(cliente.getNombres());
        clienteDB.setApellidos(cliente.getApellidos());
        clienteDB.setEmail(cliente.getEmail());

        return  clienteRepository.save(clienteDB);
    }

    @Override
    public Cliente deleteCliente(Cliente cliente) {
        Cliente clienteDB = getCliente(cliente.getId());
        if (clienteDB ==null){
            return  null;
        }
        cliente.setEstado("DELETED");
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente getCliente(Long id) {
        return  clienteRepository.findById(id).orElse(null);
    }
}
