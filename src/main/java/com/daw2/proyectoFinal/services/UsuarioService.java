package com.daw2.proyectoFinal.services;

import java.util.List;

import com.daw2.proyectoFinal.model.Proyecto;
import com.daw2.proyectoFinal.model.Tarea;
import com.daw2.proyectoFinal.model.Usuario;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorNombre(String nombreUsuario);
    Usuario obtenerUsuarioPorId(Long id);
    List<Usuario> obtenerTodosLosUsuarios();
    Usuario actualizarUsuario(Usuario usuario);
    boolean eliminarUsuario(Long id);
    List<Proyecto> obtenerProyectosDeUsuario(Long usuarioId);
}

