package com.lubricampeon.erp.services.Impl;

import com.lubricampeon.erp.entity.Cliente;
import com.lubricampeon.erp.entity.Producto;
import com.lubricampeon.erp.repository.IClienteDao;
import com.lubricampeon.erp.repository.IProductoDao;
import com.lubricampeon.erp.services.IClienteService;
import com.lubricampeon.erp.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDao productoDao;

    @Override
    public List<Producto> findAll() {return productoDao.findAll(); }

    @Override
    public Producto findById(Long id) {
        return productoDao.findById(id).get();
    }

    @Override
    public Producto save(Producto cliente) {
        return productoDao.save(cliente);
    }

    @Override
    public void delete(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    public List<Producto> findProductoByNombre(String term) {
        return productoDao.findProductoByDescripcion(term);
    }
}
