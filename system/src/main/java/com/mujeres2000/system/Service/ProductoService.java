package com.mujeres2000.system.Service;
import com.mujeres2000.system.Exception.BadRequestException;
import com.mujeres2000.system.Exception.NotFoundException;
import com.mujeres2000.system.Repository.ProductoRepository;
import com.mujeres2000.system.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    //Implementación de los métodos del repositorio

    //Creación de un producto
    public Producto crearProducto(Producto producto){
        if(productoRepository.findByName(producto.getProducto_nombre()) != null){
            throw new BadRequestException("Producto ya existente"); // manejo de excepcion hecha en la clase de exception config
        } else {
            producto.setPdvs((producto.getEnvio() + producto.getCosto_materia_prima()) * (1 + (producto.getRentabilidad()/100)));
            return productoRepository.save(producto);
        }
    }

    public Producto buscarProducto(Integer producto_id) {
        Producto productoEncontrado = productoRepository.findByProductId(producto_id);
        if (productoEncontrado == null) {
            throw new NotFoundException("Producto no existe"); // manejo de excepcion hecha en la clase de exception config
        } else {
            return productoEncontrado;
        }
    }

    public void eliminarProducto(Integer producto_id) {
        buscarProducto(producto_id);
        productoRepository.deleteByProductId(producto_id);
    }

}
