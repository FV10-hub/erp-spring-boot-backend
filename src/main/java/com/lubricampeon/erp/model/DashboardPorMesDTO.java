package com.lubricampeon.erp.model;


import java.math.BigDecimal;

public class DashboardPorMesDTO {
    private String mes;
    private int anio;
    private BigDecimal totalComprobante;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public BigDecimal getTotalComprobante() {
        return totalComprobante;
    }

    public void setTotalComprobante(BigDecimal totalComprobante) {
        this.totalComprobante = totalComprobante;
    }
}