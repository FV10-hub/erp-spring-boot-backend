package com.lubricampeon.erp.services.Impl;

import com.lubricampeon.erp.entity.Compra;
import com.lubricampeon.erp.repository.ICompraDao;
import com.lubricampeon.erp.services.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICompraServiceImpl implements ICompraService {

    @Autowired
    private ICompraDao compraDao;

    @Override
    public Compra findCompraById(Long id) {
        return compraDao.findById(id).orElse(null);
    }

    @Override
    public Compra saveCompra(Compra factura) {
        return compraDao.save(factura);
    }

    @Override
    public void deleteCompraById(Long id) {
        compraDao.deleteById(id);
    }

    @Override
    public List<Compra> listarTodos() {
        return (List<Compra>) compraDao.findAll();
    }
}
