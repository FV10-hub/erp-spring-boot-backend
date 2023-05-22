package com.lubricampeon.erp.repository;

import com.lubricampeon.erp.model.DashboardPorMesDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ComprasPorMesDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ComprasPorMesDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DashboardPorMesDTO> obtenerComprasPorMes() {
        String sql = "SELECT\n" +
                "  CASE EXTRACT(MONTH FROM meses.fecha)\n" +
                "    WHEN 1 THEN 'ENERO'\n" +
                "    WHEN 2 THEN 'FEBRERO'\n" +
                "    WHEN 3 THEN 'MARZO'\n" +
                "    WHEN 4 THEN 'ABRIL'\n" +
                "    WHEN 5 THEN 'MAYO'\n" +
                "    WHEN 6 THEN 'JUNIO'\n" +
                "    WHEN 7 THEN 'JULIO'\n" +
                "    WHEN 8 THEN 'AGOSTO'\n" +
                "    WHEN 9 THEN 'SEPTIEMBRE'\n" +
                "    WHEN 10 THEN 'OCTUBRE'\n" +
                "    WHEN 11 THEN 'NOVIEMBRE'\n" +
                "    WHEN 12 THEN 'DICIEMBRE'\n" +
                "  END AS mes,\n" +
                "  EXTRACT(YEAR FROM meses.fecha) AS anio,\n" +
                "  COALESCE(SUM(c.total_compra), 0) AS total_comprobante\n" +
                "FROM\n" +
                "  (\n" +
                "    SELECT\n" +
                "      generate_series(\n" +
                "        DATE_TRUNC('YEAR', CURRENT_DATE),\n" +
                "        DATE_TRUNC('YEAR', CURRENT_DATE) + INTERVAL '1 YEAR' - INTERVAL '1 DAY',\n" +
                "        '1 month'\n" +
                "      ) AS fecha\n" +
                "  ) AS meses\n" +
                "LEFT JOIN\n" +
                "  compras c ON DATE_TRUNC('MONTH', c.create_at) = DATE_TRUNC('MONTH', meses.fecha)\n" +
                "  AND EXTRACT(YEAR FROM c.create_at) = EXTRACT(YEAR FROM CURRENT_DATE)\n" +
                "WHERE\n" +
                "  EXTRACT(YEAR FROM c.create_at) = EXTRACT(YEAR FROM CURRENT_DATE) OR c.create_at IS NULL\n" +
                "GROUP BY\n" +
                "meses.fecha,\n" +
                "  EXTRACT(MONTH FROM meses.fecha),\n" +
                "  UPPER(TO_CHAR(meses.fecha, 'Month')),\n" +
                "  EXTRACT(YEAR FROM meses.fecha)\n" +
                "ORDER BY\n" +
                "  EXTRACT(YEAR FROM meses.fecha),\n" +
                "  EXTRACT(MONTH FROM meses.fecha);";
        return jdbcTemplate.query(sql, Collections.emptyMap(), BeanPropertyRowMapper.newInstance(DashboardPorMesDTO.class));
    }

    public List<DashboardPorMesDTO> obtenerVentasPorMes() {
        String sql = "SELECT\n" +
                "  CASE EXTRACT(MONTH FROM meses.fecha)\n" +
                "    WHEN 1 THEN 'ENERO'\n" +
                "    WHEN 2 THEN 'FEBRERO'\n" +
                "    WHEN 3 THEN 'MARZO'\n" +
                "    WHEN 4 THEN 'ABRIL'\n" +
                "    WHEN 5 THEN 'MAYO'\n" +
                "    WHEN 6 THEN 'JUNIO'\n" +
                "    WHEN 7 THEN 'JULIO'\n" +
                "    WHEN 8 THEN 'AGOSTO'\n" +
                "    WHEN 9 THEN 'SEPTIEMBRE'\n" +
                "    WHEN 10 THEN 'OCTUBRE'\n" +
                "    WHEN 11 THEN 'NOVIEMBRE'\n" +
                "    WHEN 12 THEN 'DICIEMBRE'\n" +
                "  END AS mes,\n" +
                "  EXTRACT(YEAR FROM meses.fecha) AS anio,\n" +
                "  COALESCE(SUM(c.total_factura), 0) AS total_comprobante\n" +
                "FROM\n" +
                "  (\n" +
                "    SELECT\n" +
                "      generate_series(\n" +
                "        DATE_TRUNC('YEAR', CURRENT_DATE),\n" +
                "        DATE_TRUNC('YEAR', CURRENT_DATE) + INTERVAL '1 YEAR' - INTERVAL '1 DAY',\n" +
                "        '1 month'\n" +
                "      ) AS fecha\n" +
                "  ) AS meses\n" +
                "LEFT JOIN\n" +
                "  facturas c ON DATE_TRUNC('MONTH', c.create_at) = DATE_TRUNC('MONTH', meses.fecha)\n" +
                "  AND EXTRACT(YEAR FROM c.create_at) = EXTRACT(YEAR FROM CURRENT_DATE)\n" +
                "WHERE\n" +
                "  EXTRACT(YEAR FROM c.create_at) = EXTRACT(YEAR FROM CURRENT_DATE) OR c.create_at IS NULL\n" +
                "GROUP BY\n" +
                "meses.fecha,\n" +
                "  EXTRACT(MONTH FROM meses.fecha),\n" +
                "  UPPER(TO_CHAR(meses.fecha, 'Month')),\n" +
                "  EXTRACT(YEAR FROM meses.fecha)\n" +
                "ORDER BY\n" +
                "  EXTRACT(YEAR FROM meses.fecha),\n" +
                "  EXTRACT(MONTH FROM meses.fecha);";
        return jdbcTemplate.query(sql, Collections.emptyMap(), BeanPropertyRowMapper.newInstance(DashboardPorMesDTO.class));
    }
}
