package com.lubricampeon.erp.services;

import com.lubricampeon.erp.entity.Cliente;
import com.lubricampeon.erp.entity.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();
    public Producto findById(Long id);
    public Producto save(Producto cliente);
    public void delete(Long id);
}
