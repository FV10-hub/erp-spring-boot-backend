package com.lubricampeon.erp.services;

import com.lubricampeon.erp.entity.AjusteStock;
import com.lubricampeon.erp.entity.Compra;

import java.util.List;

public interface IAjusteStockService {

    public AjusteStock findAjusteStockById(Long id);

    public AjusteStock saveAjusteStock(AjusteStock ajuste);

    public void deleteAjusteStockById(Long id);

    public List<AjusteStock> listarTodos();
}
