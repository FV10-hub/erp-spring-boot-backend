package com.lubricampeon.erp.services;

import com.lubricampeon.erp.entity.Compra;

import java.util.List;

public interface ICompraService {

    public Compra findCompraById(Long id);

    public Compra saveCompra(Compra factura);

    public void deleteCompraById(Long id);

    public List<Compra> listarTodos();
}
