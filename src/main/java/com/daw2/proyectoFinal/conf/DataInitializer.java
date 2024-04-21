package com.daw2.proyectoFinal.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.daw2.proyectoFinal.model.Anotacion;
import com.daw2.proyectoFinal.model.EstadoTarea;
import com.daw2.proyectoFinal.model.Proyecto;
import com.daw2.proyectoFinal.model.Rol;
import com.daw2.proyectoFinal.model.Tarea;
import com.daw2.proyectoFinal.model.Usuario;
import com.daw2.proyectoFinal.services.AnotacionService;
import com.daw2.proyectoFinal.services.ProyectoService;
import com.daw2.proyectoFinal.services.TareaService;
import com.daw2.proyectoFinal.services.UsuarioService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AnotacionService anotacionService;

	@Autowired
	private ProyectoService proyectoService;

	@Autowired
	private TareaService tareaService;

	@Override
	public void run(String... args) {

		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();

		if (usuarioService.obtenerUsuarioPorId(1L) == null) {

			usuario3.setNombreUsuario("admin");
			usuario3.setCorreoElectronico("admin@example.com");
			usuario3.setContraseña("adminpassword");
			usuario3.setRol(Rol.ADMINISTRADOR);
			usuarioService.crearUsuario(usuario3);

			usuario1.setNombreUsuario("usuario1");
			usuario1.setCorreoElectronico("usuario1@example.com");
			usuario1.setContraseña("password1");
			usuarioService.crearUsuario(usuario1);

			usuario2.setNombreUsuario("usuario2");
			usuario2.setCorreoElectronico("usuario2@example.com");
			usuario2.setContraseña("password2");
			usuarioService.crearUsuario(usuario2);

			// Crear Anotaciones para usuario2
			Anotacion anotacion1 = new Anotacion();
			anotacion1.setContenido("Primera anotacion de usuario2");
			anotacion1.setTitulo("Prueba1");
			anotacion1.setUsuario(usuario2);

			Anotacion anotacion2 = new Anotacion();
			anotacion2.setContenido("Segunda anotacion de usuario2");
			anotacion2.setTitulo("Prueba2");
			anotacion2.setUsuario(usuario2);

			anotacionService.crearAnotacion(anotacion1);
			anotacionService.crearAnotacion(anotacion2);
			
			// Crear Proyecto
			Proyecto proyecto = new Proyecto();
			proyecto.setNombre("Proyecto1");
			proyecto.setDescripcion("Descripción del Proyecto1");

			proyecto = proyectoService.crearProyecto(proyecto);

			// Agregar Usuarios al Proyecto
			proyecto.setUsuarios(new HashSet<>(Arrays.asList(usuario1, usuario2, usuario3)));
			proyectoService.crearProyecto(proyecto);

			// Crear Tareas para el Proyecto
			Tarea tarea1 = new Tarea();
			tarea1.setNombre("Tarea1");
			tarea1.setDescripcion("Descripción de Tarea1");
			tarea1.setFechaVencimiento(LocalDate.now().plusDays(7));
			tarea1.setEstado(EstadoTarea.COMPLETADA);

			tarea1.setProyecto(proyecto);
			tareaService.crearTarea(tarea1);

			Tarea tarea2 = new Tarea();
			tarea2.setNombre("Tarea2");
			tarea2.setDescripcion("Descripción de Tarea2");
			tarea2.setFechaVencimiento(LocalDate.now().plusDays(14));
			tarea2.setEstado(EstadoTarea.EN_PROGRESO);

			tarea2.setProyecto(proyecto);
			tareaService.crearTarea(tarea2);

			Tarea tarea3 = new Tarea();
			tarea3.setNombre("Tarea3");
			tarea3.setDescripcion("Descripción de Tarea3");
			tarea3.setFechaVencimiento(LocalDate.now().plusDays(21));
			tarea3.setEstado(EstadoTarea.EN_PROGRESO);

			tarea3.setProyecto(proyecto);
			tareaService.crearTarea(tarea3);

			Tarea tarea4 = new Tarea();
			tarea4.setNombre("Tarea4");
			tarea4.setDescripcion("Descripción de Tarea4");
			tarea4.setFechaVencimiento(LocalDate.now().plusDays(28));
			tarea4.setEstado(EstadoTarea.PENDIENTE);

			tarea4.setProyecto(proyecto);
			tareaService.crearTarea(tarea4);
		}
	}

}
