package com.lubricampeon.erp.services;

import com.lubricampeon.erp.entity.Proveedor;

import java.util.List;

public interface IProveedorService {
    public List<Proveedor> findAll();
    public Proveedor findById(Long id);
    public Proveedor save(Proveedor proveedor);
    public void delete(Long id);
}
