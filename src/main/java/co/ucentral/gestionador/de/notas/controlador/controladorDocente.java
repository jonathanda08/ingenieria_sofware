package co.ucentral.gestionador.de.notas.controlador;

import co.ucentral.gestionador.de.notas.servicios.ServicioDocente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controladorDocente {

    @Autowired
    ServicioDocente servDocente;

    @GetMapping("/")
    public String inicio(){
        return "redirect:/docentes/lista";
    }

    @GetMapping("/docentes/lista")
    public String mostrar(Model model){
        model.addAttribute("docente",servDocente.listar());
        return "docentes";
    }
}
