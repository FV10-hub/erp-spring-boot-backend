package com.lubricampeon.erp.services;

import com.lubricampeon.erp.entity.Cliente;
import com.lubricampeon.erp.entity.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();
    public Producto findById(Long id);

    public Producto findByCodigoBarra(String codigoBarra);
    public Producto save(Producto cliente);
    public void delete(Long id);
    public List<Producto> findProductoByNombre(String term);
}
