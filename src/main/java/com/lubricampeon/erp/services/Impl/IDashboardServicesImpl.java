package com.lubricampeon.erp.services.Impl;

import com.lubricampeon.erp.model.DashboardPorMesDTO;
import com.lubricampeon.erp.repository.ComprasPorMesDao;
import com.lubricampeon.erp.services.IDashboardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDashboardServicesImpl implements IDashboardServices {

    @Autowired
    private ComprasPorMesDao comprasPorMesDao;

    @Override
    public List<DashboardPorMesDTO> obtenerComprasPorMes() {
        return comprasPorMesDao.obtenerComprasPorMes();
    }

    @Override
    public List<DashboardPorMesDTO> obtenerVentasPorMes() {
        return comprasPorMesDao.obtenerVentasPorMes();
    }
}
