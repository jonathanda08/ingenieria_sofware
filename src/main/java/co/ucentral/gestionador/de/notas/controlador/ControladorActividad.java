package co.ucentral.gestionador.de.notas.controlador;

import co.ucentral.gestionador.de.notas.dto.ActividadDto;
import co.ucentral.gestionador.de.notas.servicios.ServicioActividad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControladorActividad {

    private final ServicioActividad servicioActividad;

    public ControladorActividad(ServicioActividad servicioActividad) {
        this.servicioActividad = servicioActividad;
    }

    @GetMapping("/lista/Actividad")
    public String listarActividades(Model model) {
        List<ActividadDto> listaActividades = servicioActividad.listar();
        model.addAttribute("listaActividad", listaActividades);
        return "listaActividad";
    }

    @GetMapping("/Actividad/formulario")
    public String cargarActividadModal(Model model) {
        ActividadDto actividadDto = new ActividadDto();
        model.addAttribute("actividadLlenar", actividadDto);
        return "actividad";
    }

    @PostMapping("/Actividad/nuevo")
    public String crearActividad(ActividadDto actividad){
        servicioActividad.ingresar(actividad);
        return "redirect:/lista/Actividad";
    }

}

