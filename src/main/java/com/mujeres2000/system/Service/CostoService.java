package com.mujeres2000.system.Service;

import com.mujeres2000.system.Repository.CostoRepository;
import com.mujeres2000.system.model.Costo;
import com.mujeres2000.system.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CostoService {
    @Autowired
    CostoRepository costoRepository;

    @Autowired
    UsuarioService usuarioService;

    public void crearCosto(Costo costo, Integer usuarioId) {
        Usuario usuario = usuarioService.obtenerUsuario(usuarioId);
        costo.setUsuario(usuario);
        costoRepository.save(costo);
    }

    public List<Costo> listarCostos(Integer usuarioId) {
        return costoRepository.findAllByUsuarioId(usuarioId);
    }
}
