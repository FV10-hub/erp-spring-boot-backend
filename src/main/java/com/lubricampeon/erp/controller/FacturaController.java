package com.lubricampeon.erp.controller;

import com.lubricampeon.erp.entity.Factura;
import com.lubricampeon.erp.services.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @GetMapping("/facturas")
    public List<Factura> listarTodos() {
        return facturaService.listarTodos();
    }

    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Factura show(@PathVariable Long id) {
        return facturaService.findFacturaById(id);
    }

    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        facturaService.deleteFacturaById(id);
    }

    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura factura) {
        return facturaService.saveFactura(factura);
    }

}
