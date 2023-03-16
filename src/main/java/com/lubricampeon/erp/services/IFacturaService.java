package com.lubricampeon.erp.services;

import com.lubricampeon.erp.entity.Factura;
import com.lubricampeon.erp.entity.Producto;

import java.util.List;

public interface IFacturaService {

    public Factura findFacturaById(Long id);

    public Factura saveFactura(Factura factura);

    public void deleteFacturaById(Long id);
    public List<Factura> listarTodos();
}
