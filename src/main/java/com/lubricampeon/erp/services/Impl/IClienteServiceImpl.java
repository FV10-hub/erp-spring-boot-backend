package com.lubricampeon.erp.services.Impl;

import com.lubricampeon.erp.entity.Cliente;
import com.lubricampeon.erp.repository.IClienteDao;
import com.lubricampeon.erp.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteDao.findById(id).get();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }
}
