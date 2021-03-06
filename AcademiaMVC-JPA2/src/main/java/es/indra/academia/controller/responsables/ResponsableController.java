package es.indra.academia.controller.responsables;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.indra.academia.authentication.MyUserDetails;
import es.indra.academia.model.entities.ResponsableAlumno;
import es.indra.academia.model.service.ResponsableAlumnoService;

@Controller
@RequestMapping("/admin/responsables")
public class ResponsableController {
	@Autowired
	ResponsableAlumnoService profesorService;

	@Autowired
	ResponsableFormValidator validador;
	private Logger log = LogManager.getLogger(ResponsableController.class);

	@RequestMapping(value = "/listado.html", method = RequestMethod.GET)
	public String listado(Model model) {
		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername(); // get logged in username

		this.log.info("listado Profesores");
		List<ResponsableAlumno> listado = this.profesorService.findAll();
		model.addAttribute("listado", listado);
		return "responsables/listado";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.GET)
	public String nuevo(Model model) {
		model.addAttribute("responsable", new ResponsableForm(new ResponsableAlumno()));
		return "responsables/nuevo";
	}

	@RequestMapping(value = "/nuevo.html", method = RequestMethod.POST)
	public String nuevoPost(@Valid @ModelAttribute("responsable") ResponsableForm form, BindingResult result) {
		ArrayList<String> errores = new ArrayList<String>();
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "responsables/nuevo";

		} else {

			this.profesorService.create(form.obtenerResponsableAlumno());
			return "redirect:/admin/responsables/listado.html?mensaje=correcto";

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.GET)
	public String modificar(@RequestParam("id") Long id, Model model) {
		if (id == null) {
			return "redirect:/admin/responsables/listado.html?mensaje=errorId";

		} else {
			ResponsableAlumno responsable = this.profesorService.find(id);
			if (responsable != null) {
				ResponsableForm form = new ResponsableForm(responsable);
				model.addAttribute("responsable", form);
				return "responsables/modificar";

			} else {
				return "redirect:/admin/responsables/listado.html?mensaje=errorId";
			}

		}

	}

	@RequestMapping(value = "/modificar.html", method = RequestMethod.POST)
	public String modificarPost(@Valid @ModelAttribute("responsable") ResponsableForm form, BindingResult result) {
		this.validador.validate(form, result);
		if (result.hasErrors()) {
			return "responsables/modificar";

		} else {

			this.profesorService.create(form.obtenerResponsableAlumno());
			return "redirect:/admin/responsables/listado.html?mensaje=correcto";

		}

	}

	@RequestMapping(value = "/eliminar.html", method = RequestMethod.GET)
	public String eliminar(@RequestParam("id") Long id, Model model) {

		if (id == null) {
			return "redirect:/admin/responsables/listado.html?mensaje=errorId";
		} else {
			ResponsableAlumno responsable = this.profesorService.find(id);
			if (responsable != null) {
				this.profesorService.delete(id);
				return "redirect:/admin/responsables/listado.html?mensaje=correcto";
			} else {
				return "redirect:/admin/responsables/listado.html?mensaje=errorId";
			}

		}

	}

}
