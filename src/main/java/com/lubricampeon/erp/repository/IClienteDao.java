package com.lubricampeon.erp.repository;

import com.lubricampeon.erp.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

}
