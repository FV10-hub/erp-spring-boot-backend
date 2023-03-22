package com.lubricampeon.erp.controller;

import com.lubricampeon.erp.entity.Compra;
import com.lubricampeon.erp.entity.Compra;
import com.lubricampeon.erp.services.ICompraService;
import com.lubricampeon.erp.services.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class CompraController {

    @Autowired
    private ICompraService comppraService;

    @GetMapping("/compras")
    public List<Compra> listarTodos() {
        return comppraService.listarTodos();
    }

    @GetMapping("/compras/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Compra show(@PathVariable Long id) {
        return comppraService.findCompraById(id);
    }

    @DeleteMapping("/compras/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        comppraService.deleteCompraById(id);
    }

    @PostMapping("/compras")
    @ResponseStatus(HttpStatus.CREATED)
    public Compra crear(@RequestBody Compra factura) {
        return comppraService.saveCompra(factura);
    }

}
