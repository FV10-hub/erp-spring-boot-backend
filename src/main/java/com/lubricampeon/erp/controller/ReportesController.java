package com.lubricampeon.erp.controller;

import com.lubricampeon.erp.utils.JaperReportGenerator;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ReportesController {

    private final JaperReportGenerator reportGenerator;

    @Autowired
    public ReportesController(JaperReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    @GetMapping("/reportes/{reportName}")
    public ResponseEntity<?> downloadReport(
            @PathVariable String reportName,
            //@RequestParam Map<String, String> parameters,
            @RequestBody Map<String, Object> parameters,
            @RequestParam(defaultValue = "PDF") String format
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            // Generar y descargar el informe adjunto
            return reportGenerator.generateReport(reportName, parameters, format);
        } catch (IOException | JRException e) {
            // Manejar errores si es necesario
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage());
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
