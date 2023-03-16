package com.lubricampeon.erp.repository;

import com.lubricampeon.erp.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductoDao extends CrudRepository<Producto, Long>{

	public List<Producto> findAll();

	@Query("select p from Producto p where p.descripcion like %?1%")
	public List<Producto> findByDescripcion(String term);
	
	public List<Producto> findByDescripcionContainingIgnoreCase(String term);
	
	public List<Producto> findByDescripcionStartingWithIgnoreCase(String term);

	public List<Producto> findProductoByDescripcion(String term);
}
