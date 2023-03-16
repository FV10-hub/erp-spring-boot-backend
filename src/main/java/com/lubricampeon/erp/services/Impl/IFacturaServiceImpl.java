package com.lubricampeon.erp.services.Impl;

import com.lubricampeon.erp.entity.Factura;
import com.lubricampeon.erp.repository.IFacturaDao;
import com.lubricampeon.erp.services.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFacturaServiceImpl implements IFacturaService {

    @Autowired
    private IFacturaDao facturaDao;

    @Override
    public Factura findFacturaById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    public Factura saveFactura(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    public void deleteFacturaById(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    public List<Factura> listarTodos() {
        return (List<Factura>) facturaDao.findAll();
    }
}
