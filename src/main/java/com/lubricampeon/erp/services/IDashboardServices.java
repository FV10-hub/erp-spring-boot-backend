package com.lubricampeon.erp.services;

import com.lubricampeon.erp.model.DashboardPorMesDTO;

import java.util.List;

public interface IDashboardServices {
    public List<DashboardPorMesDTO> obtenerComprasPorMes();
    public List<DashboardPorMesDTO> obtenerVentasPorMes();
}
