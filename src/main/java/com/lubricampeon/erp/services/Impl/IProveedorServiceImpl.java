package com.lubricampeon.erp.services.Impl;

import com.lubricampeon.erp.entity.Proveedor;
import com.lubricampeon.erp.repository.IProveedorDao;
import com.lubricampeon.erp.services.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorDao proveedorDao;

    @Override
    public List<Proveedor> findAll() {
        return proveedorDao.findAll();
    }

    @Override
    public Proveedor findById(Long id) {
        return proveedorDao.findById(id).get();
    }

    @Override
    public Proveedor save(Proveedor cliente) {
        return proveedorDao.save(cliente);
    }

    @Override
    public void delete(Long id) {
        proveedorDao.deleteById(id);
    }
}
