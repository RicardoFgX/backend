package com.daw2.proyectoFinal.services;

import java.util.List;

import com.daw2.proyectoFinal.model.Proyecto;
import com.daw2.proyectoFinal.model.Tarea;
import com.daw2.proyectoFinal.model.Usuario;

public interface ProyectoService {
    Proyecto crearProyecto(Proyecto proyecto);
    Proyecto obtenerProyectoPorId(Long id);
    List<Proyecto> obtenerTodosLosProyectos();
    boolean eliminarProyecto(Long id);
    Proyecto actualizarProyecto(Proyecto proyecto);
    List<Proyecto> obtenerProyectosConUsuario(Long usuarioId);
}

