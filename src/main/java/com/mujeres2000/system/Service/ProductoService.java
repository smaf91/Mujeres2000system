package com.mujeres2000.system.Service;
import com.mujeres2000.system.Exception.BadRequestException;
import com.mujeres2000.system.Exception.NotFoundException;
import com.mujeres2000.system.Repository.ProductoRepository;
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

    @Autowired
    UsuarioService usuarioService;

    //Implementación de los métodos del repositorio

    //Creación de un producto
    public Producto crearProducto(Producto producto, Integer usuarioId) {
        Producto productoGuardado = productoRepository.findByNameAndUsuarioId(producto.getProducto_nombre(), usuarioId);
        if(productoGuardado != null){
            throw new BadRequestException("Producto ya existente"); // manejo de excepcion hecha en la clase de exception config
        } else {
            Usuario usuario = usuarioService.obtenerUsuario(usuarioId);
            producto.setUsuario(usuario);
            producto.setPdvs((producto.getEnvio() + producto.getCosto_materia_prima()) * (1 + (producto.getRentabilidad()/100)));
            return productoRepository.save(producto);
        }
    }

    public Producto buscarProducto(Integer producto_id, Integer usuarioId) {
        usuarioService.obtenerUsuario(usuarioId);
        Producto productoEncontrado = productoRepository.findByProductIdAndUsuarioId(producto_id, usuarioId);
        if (productoEncontrado == null) {
            throw new NotFoundException("Producto no existe"); // manejo de excepcion hecha en la clase de exception config
        } else {
            return productoEncontrado;
        }
    }

    public List<Producto> listarProductos(Integer usuarioId) {
        usuarioService.obtenerUsuario(usuarioId);
        List<Producto> productos = productoRepository.findAllProductsByUsuarioId(usuarioId);
        return productos;
    }

    public void eliminarProducto(Integer producto_id, Integer usuarioId) {
        usuarioService.obtenerUsuario(usuarioId);
        buscarProducto(producto_id, usuarioId);
        productoRepository.deleteByProductId(producto_id);
    }

}
