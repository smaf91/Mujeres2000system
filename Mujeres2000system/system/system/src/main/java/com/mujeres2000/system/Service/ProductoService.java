package com.mujeres2000.system.Service;

import com.mujeres2000.system.Exception.BadRequestException;
import com.mujeres2000.system.Repository.ProductoRepository;
import com.mujeres2000.system.Repository.UsuarioRepository;
import com.mujeres2000.system.model.Producto;
import com.mujeres2000.system.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    //Implementación de los métodos del repositorio

    //Creación de un producto
    public Producto crearProducto(Producto producto){
        // comprobar que el producto no exista ya en la base de datos falta
        return productoRepository.save(producto);
    }
    //Eliminación de un producto
    public void eliminarProducto (Producto producto){
        productoRepository.delete(producto);
    }


    //lista de productos
    public List<Producto> obtenerTodosLosProductos(){
        List<Producto> listaDeProductos = productoRepository.findAll();
        return listaDeProductos;
    }




}
