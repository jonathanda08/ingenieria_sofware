package co.ucentral.gestionador.de.notas.controlador;

import co.ucentral.gestionador.de.notas.serviciosEstudiante.ServicioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorEstudiante {

    @Autowired
    ServicioEstudiante servEstudiante;

    @GetMapping("/")
    public String inicio(){
        return "redirect:/estudiantes/lista";
    }

    @GetMapping("/estudiantes/lista")
    public String mostrar(Model model){
        model.addAttribute("estudiante",servEstudiante.listar());
        return "estudiantes";
    }
}
