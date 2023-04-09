package com.lubricampeon.erp.controller;

import com.lubricampeon.erp.entity.AjusteStock;
import com.lubricampeon.erp.entity.Compra;
import com.lubricampeon.erp.services.IAjusteStockService;
import com.lubricampeon.erp.services.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class AjusteStockController {

    @Autowired
    private IAjusteStockService ajusteStockService;

    @GetMapping("/ajusteStock")
    public List<AjusteStock> listarTodos() {
        return ajusteStockService.listarTodos();
    }

    @GetMapping("/ajusteStock/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AjusteStock show(@PathVariable Long id) {
        return ajusteStockService.findAjusteStockById(id);
    }

    @DeleteMapping("/ajusteStock/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        ajusteStockService.deleteAjusteStockById(id);
    }

    @PostMapping("/ajusteStock")
    @ResponseStatus(HttpStatus.CREATED)
    public AjusteStock crear(@RequestBody AjusteStock factura) {
        return ajusteStockService.saveAjusteStock(factura);
    }

}
