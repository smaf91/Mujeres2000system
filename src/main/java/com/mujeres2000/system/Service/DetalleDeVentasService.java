package com.mujeres2000.system.Service;
import com.mujeres2000.system.Exception.NotFoundException;
import com.mujeres2000.system.Repository.DetalleDeVentasRepository;
import com.mujeres2000.system.model.DetalleDeVentas;
import com.mujeres2000.system.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DetalleDeVentasService {

    @Autowired
    DetalleDeVentasRepository detalleDeVentasRepository;

    @Autowired
    UsuarioService usuarioService;

    public void registrarVenta(DetalleDeVentas detalleDeVentas, Integer usuarioId){
        Usuario usuario = usuarioService.obtenerUsuario(usuarioId);
        detalleDeVentas.setUsuario(usuario);
        detalleDeVentasRepository.save(detalleDeVentas);
    }

    public List<DetalleDeVentas>  listarVentas (Integer usuario_id) {
        return detalleDeVentasRepository.findAllByUsuarioId(usuario_id);
    }

    public DetalleDeVentas buscarVenta (Integer venta_id, Integer usuario_id) {
        DetalleDeVentas ventaEncontrada = detalleDeVentasRepository.findByVentaIdAndUsuarioId(venta_id, usuario_id);
        if (ventaEncontrada == null) {
            throw new NotFoundException("Venta no existe"); // manejo de excepcion hecha en la clase de exception config
        } else {
            return ventaEncontrada;
        }
    }

}
