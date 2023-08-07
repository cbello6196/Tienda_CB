package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoDao productoDao;

    @Autowired
    public ProductoServiceImpl(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    @Override
    public List<Producto> getProductos(boolean activos) {
        return productoDao.findAll();
    }

    @Override
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
// Lista de productos con precio entre pedidos por descripción ConsultaAmpliada

    @Override

    @Transactional(readOnly = true)//lo mismo que va en dao y retorna las variables

    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {

        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);

    }

    @Override

    @Transactional(readOnly = true)

    public List<Producto> metodoJPQL(double precioInf, double precioSup) {

        return productoDao.metodoJPQL(precioInf, precioSup);

    }

    @Override

    @Transactional(readOnly = true)

    public List<Producto> metodoNativo(double precioInf, double precioSup) {

        return productoDao.metodoNativo(precioInf, precioSup);

    }

}
