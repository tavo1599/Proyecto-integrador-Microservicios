package com.quispcs.clienteservice.repository;

import com.quispcs.clienteservice.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    public Cliente findBydni(String dni);
}
