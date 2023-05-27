package com.lubricampeon.erp.utils;

public final class Constantes {

    //TODO: esta variale se usa para contenedores docker
    public static final String JASPER_FILES_PATH_DOCKER = "/app/jasper";

    public static final String SEPARADOR_WINDOWS = "\\";
    public static final String CARPETA_WINDOWS = "C:\\Sistema\\imagenes";
    public static final String CARPETA_LINUX = "/home/Sistema/CapitalSys/";
    //TODO: si el servicio se ejecuta en local descomentar esta linea
   // public static final String CARPETA_REPORTES_WINDOWS = "D:\\Sistema\\reportes";
    public static final String CARPETA_REPORTES_WINDOWS = JASPER_FILES_PATH_DOCKER;//"/app/reportes";
    public static final String CARPETA_REPORTES_LINUX = "/home/Sistema/Informes";

}
