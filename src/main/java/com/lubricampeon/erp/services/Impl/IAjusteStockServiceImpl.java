package com.lubricampeon.erp.services.Impl;

import com.lubricampeon.erp.entity.AjusteStock;
import com.lubricampeon.erp.repository.IAjusteStockDao;
import com.lubricampeon.erp.services.IAjusteStockService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IAjusteStockServiceImpl implements IAjusteStockService {

    @Autowired
    private IAjusteStockDao iAjusteStockDao;

    @Override
    public AjusteStock findAjusteStockById(Long id) {
        return iAjusteStockDao.findById(id).orElse(null);
    }

    @Override
    public AjusteStock saveAjusteStock(AjusteStock ajuste) {
        return iAjusteStockDao.save(ajuste);
    }

    @Override
    public void deleteAjusteStockById(Long id) {
        iAjusteStockDao.deleteById(id);
    }

    @Override
    public List<AjusteStock> listarTodos() {
        return (List<AjusteStock>) iAjusteStockDao.findAll();
    }
}
