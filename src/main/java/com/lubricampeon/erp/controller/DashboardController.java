package com.lubricampeon.erp.controller;

import com.lubricampeon.erp.model.DashboardPorMesDTO;
import com.lubricampeon.erp.services.IDashboardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class DashboardController {

    private final IDashboardServices iDashboardServices;

    @Autowired
    public DashboardController(IDashboardServices iDashboardServices) {
        this.iDashboardServices = iDashboardServices;
    }

    @GetMapping("/dashboard/{tipo}")
    public ResponseEntity<?> dashboard(@PathVariable String tipo) {
        try {
            List<DashboardPorMesDTO> lista = new ArrayList<>();
            if ("compras".equalsIgnoreCase(tipo)) {
                lista = iDashboardServices.obtenerComprasPorMes();
            } else if ("ventas".equalsIgnoreCase(tipo)) {
                lista = iDashboardServices.obtenerVentasPorMes();
            }
            int a = 0;
            return ResponseEntity.status(HttpStatus.OK).body(lista);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
