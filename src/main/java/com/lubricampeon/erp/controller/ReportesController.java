package com.lubricampeon.erp.controller;

import com.lubricampeon.erp.utils.JaperReportGenerator;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    public ResponseEntity<byte[]> downloadReport(
            @PathVariable String reportName,
            @RequestParam Map<String, String> parameters,
            @RequestParam(defaultValue = "PDF") String format
    ) {
        try {
            // Convertir los parámetros de String a Object si es necesario
            Map<String, Object> reportParameters = new HashMap<>();
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                reportParameters.put(entry.getKey(), entry.getValue());
            }

            // Generar y descargar el informe adjunto
            return reportGenerator.generateReport(reportName, reportParameters, format);
        } catch (IOException | JRException e) {
            // Manejar errores si es necesario
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
