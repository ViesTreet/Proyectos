package com.codingdojo.javierulloa.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.javierulloa.modelos.Tarea;
import com.codingdojo.javierulloa.modelos.Usuario;
import com.codingdojo.javierulloa.servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorBase {

	@Autowired
	private Servicios servicio;
	
	
	@GetMapping("/")
	public String home(@ModelAttribute("registro")Usuario usuario) {
		
		return "home.jsp";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("registro")Usuario usuario,BindingResult result,HttpSession session) {
		servicio.registrar(usuario, result);
		if(result.hasErrors()) {
			return "home.jsp";
		} else {
			session.setAttribute("usuarioEnSesion", usuario);
			return "redirect:/tasks";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("loginEmail")String email,@RequestParam("loginContrasena")String contrasena,RedirectAttributes redirectAttributes,HttpSession session) {
		Usuario usuarioInicioSesion = servicio.login(email, contrasena);
		if(usuarioInicioSesion == null) {
			redirectAttributes.addFlashAttribute("error_login", "El correo/contraseña es incorrecto");
			return "redirect:/";
		} else {
			session.setAttribute("usuarioEnSesion", usuarioInicioSesion);
			return "redirect:/tasks";
		}
	}
	
	@GetMapping("/tasks")
	public String dashboard(HttpSession session,Model model,@RequestParam(name = "orden", required = false, defaultValue = "nor")String orden) {
		
		if(session.getAttribute("usuarioEnSesion")==null) {
			return "redirect:/";
		} else {
			
			if(orden.equals("asc")) {
				List<Tarea> tarea = servicio.ordenarAsc();
				model.addAttribute("tareas",tarea);
				
			} else if(orden.equals("desc")) {
				List<Tarea> tarea = servicio.ordenarDesc();
				model.addAttribute("tareas",tarea);
			} else {
				List<Tarea> tarea = servicio.todasLasTareas();
				model.addAttribute("tareas",tarea);
			}
			
			
			Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion");
			model.addAttribute("usuario",usuarioEnSesion);
			return "tasks.jsp"; 
		}
	}
	
	@GetMapping("/logout")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/tasks/new")
	public String nuevaTarea(HttpSession session,@ModelAttribute("nuevaTarea")Tarea tarea,Model model) {
		if(session.getAttribute("usuarioEnSesion")==null) {
			return "redirect:/";
		} else {
			List<Usuario> listaUsuario = servicio.todosLosUsuario();
			model.addAttribute("usuarios",listaUsuario);
			return "nuevaTarea.jsp";
		}
	}
	
	@PostMapping("/nuevo")
	public String nuevo(@Valid HttpSession session,@ModelAttribute("nuevaTarea")Tarea tarea,Model model,BindingResult result) {
		if(session.getAttribute("usuarioEnSesion")==null) {
			return "redirect:/";
		} else {
			if(result.hasErrors()) {
				List<Usuario> listaUsuario = servicio.todosLosUsuario();
				model.addAttribute("usuarios",listaUsuario);
				return "nuevaTarea.jsp";
			} else {
				servicio.guardarTarea(tarea);
				return "redirect:/tasks";
			}
		}
	}
	
	@GetMapping("/tasks/{id}")
	public String tasksId(HttpSession session,@PathVariable("id")Long id,Model model) {
		
		if(session.getAttribute("usuarioEnSesion")==null) {
			return "redirect:/";
		} else {
			Tarea tareaActual = servicio.tareaPorId(id);
			model.addAttribute("tarea",tareaActual);
			return "tareaBuscada.jsp";
		}
	}
	
	@GetMapping("/tasks/{id}/edit")
	public String editarTask(HttpSession session,@PathVariable("id")Long id,Model model) {
		if(session.getAttribute("usuarioEnSesion")==null) {
			return "redirect:/";
		} else {
			Tarea tarea = servicio.tareaPorId(id);
			Long idDelCreadorDeLaTarea = tarea.getCreador().getId();
			
			Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion");
			Long idDelUsuarioEnSesion = usuarioEnSesion.getId();
			if(idDelCreadorDeLaTarea.equals(idDelUsuarioEnSesion)) {
				List<Usuario> listaUsuario = servicio.todosLosUsuario();
				model.addAttribute("usuarios",listaUsuario);
				
				model.addAttribute("tareaActual",tarea);
				
				return "editar.jsp";
			} else {
				return "redirect:/tasks";
			}
		}
	}
	
	@PutMapping("/editar")
	public String editar(HttpSession session,RedirectAttributes redirectAttribute,@RequestParam("idTarea")Long idTarea,@RequestParam("creador")Long idCreador,@RequestParam("nombreTarea")String nombreTarea,@RequestParam("asignado")Long asignado,@RequestParam("prioridad")int prioridad) {
		if(session.getAttribute("usuarioEnSesion")==null) {
			return "redirect:/";
		} else {
			if(nombreTarea == null || nombreTarea.trim().isEmpty()) {
				redirectAttribute.addFlashAttribute("error", "El nombre de la tarea es obligatorio.");
	            return "redirect:/tasks/"+idTarea+"/edit";
			} else {
				servicio.actualizarTarea(idTarea, idCreador, nombreTarea, asignado, prioridad);
				return "redirect:/tasks";
			}
		}
	}
	
	@DeleteMapping("/tasks/{id}/delete")
	public String eliminarOCompletar(HttpSession session,@PathVariable("id")Long id) {
		if(session.getAttribute("usuarioEnSesion")==null) {
			return "redirect:/";
		} else {
			servicio.eliminarTarea(id);
			return "redirect:/tasks";
		}
	}
}
