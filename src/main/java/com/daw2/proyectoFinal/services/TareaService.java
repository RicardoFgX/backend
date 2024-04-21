package com.daw2.proyectoFinal.services;

import java.util.List;

import com.daw2.proyectoFinal.model.Tarea;
import com.daw2.proyectoFinal.model.Usuario;

public interface TareaService {
    Tarea crearTarea(Tarea tarea);
    Tarea obtenerTareaPorId(Long id);
    List<Tarea> obtenerTodasLasTareas();
    List<Tarea> obtenerTareasPorProyecto(Long proyectoId);
    boolean eliminarTarea(Long id);
    Tarea actualizarTarea(Tarea tarea);

}

