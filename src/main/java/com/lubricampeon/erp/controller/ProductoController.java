package com.lubricampeon.erp.controller;

import com.lubricampeon.erp.entity.Producto;
import com.lubricampeon.erp.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "http://localhost:4200/cliente", "*" })
@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> index() {
        return productoService.findAll();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Producto producto = null;
        Map<String, Object> response = new HashMap<>();

        try {
            producto = productoService.findById(id);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(producto == null) {
            response.put("mensaje", "El producto ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    @PostMapping("/productos")
    public ResponseEntity<?> create(@RequestBody Producto producto) {

        Producto productoNew = null;
        Map<String, Object> response = new HashMap<>();

        try {
            productoNew = productoService.save(producto);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto ha sido creado con éxito!");
        response.put("producto", productoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Long id) {

        Producto productoActual = productoService.findById(id);

        Producto productoUpdated = null;

        Map<String, Object> response = new HashMap<>();

        if (productoActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el producto ID: "
                    .concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {

            productoActual.setCodigoBarra(producto.getCodigoBarra());
            productoActual.setDescripcion(producto.getDescripcion());
            productoActual.setExistencia(producto.getExistencia());
            productoActual.setPrecio(producto.getPrecio());
            productoActual.setCreateAt(producto.getCreateAt());

            productoUpdated = productoService.save(productoActual);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el producto en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto ha sido actualizado con éxito!");
        response.put("producto", productoUpdated);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        try {
            Producto producto = productoService.findById(id);
            productoService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el producto de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El producto eliminado con éxito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/productos/filtrar-productos/{term}")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> filtrarProductos(@PathVariable String term){
        return productoService.findProductoByNombre(term);
    }


}
