package com.lubricampeon.erp.utils;

import com.lubricampeon.erp.utils.Constantes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.Map;

@Component
public class JaperReportGenerator {

    public ResponseEntity<byte[]> generateReport(String reportName,
                                                 Map<String, Object> parameters,
                                                 String format)
    throws FileNotFoundException, JRException, IOException {

        String separator = File.separator;
        String path = Constantes.CARPETA_REPORTES_WINDOWS;
        String reportPath = path + separator + reportName + ".jasper";
        // Cargar el archivo Jasper
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new FileInputStream(reportPath));

        // Rellenar el informe con los parámetros proporcionados
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        // Exportar el informe a PDF o XLS
        byte[] reportBytes;
        String contentType;
        String fileExtension;
        if (format.equalsIgnoreCase("PDF")) {
            reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);
            contentType = MediaType.APPLICATION_PDF_VALUE;
            fileExtension = "pdf";
        } else if (format.equalsIgnoreCase("XLS")) {
            JRXlsExporter exporter = new JRXlsExporter();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            exporter.exportReport();
            reportBytes = outputStream.toByteArray();
            contentType = "application/vnd.ms-excel";
            fileExtension = "xls";
        } else {
            throw new IllegalArgumentException("Formato de informe no válido. Debe ser PDF o XLS.");
        }

        // Configurar las cabeceras de la respuesta
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(contentType));
        headers.setContentDispositionFormData(reportName, reportName + "." + fileExtension);

        // Enviar el archivo adjunto como respuesta
        return new ResponseEntity<>(reportBytes, headers, HttpStatus.OK);
    }
}
