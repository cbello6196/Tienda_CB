
package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoDao productoDao;

    @Autowired
    public ProductoServiceImpl(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    @Override
    public List<Producto> getProductos(boolean activos) {
        // Implementa la lógica para obtener la lista de productos
        // Puedes utilizar el método proporcionado por el ProductoDao
        return productoDao.findAll();
    }

    @Override
    public Producto getProducto(Producto producto) {
        // Implementa la lógica para obtener un producto en particular
        // Puedes utilizar el método proporcionado por el ProductoDao
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        // Implementa la lógica para guardar un producto
        // Puedes utilizar el método proporcionado por el ProductoDao
        productoDao.save(producto);
    }

    @Override
    public void delete(Producto producto) {
        // Implementa la lógica para eliminar un producto
        // Puedes utilizar el método proporcionado por el ProductoDao
        productoDao.delete(producto);
    }
}


