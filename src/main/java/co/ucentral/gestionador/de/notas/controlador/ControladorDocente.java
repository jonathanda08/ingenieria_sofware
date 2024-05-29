package co.ucentral.gestionador.de.notas.controlador;

import co.ucentral.gestionador.de.notas.dto.DocenteDto;
import co.ucentral.gestionador.de.notas.servicios.ServicioDocente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControladorDocente {


    ServicioDocente servDocente;

    public ControladorDocente(ServicioDocente servDocente) {
        this.servDocente = servDocente;
    }


    @GetMapping("/docentes/lista")
    public String listarDocentes(Model model){
        List<DocenteDto> listaDocentes = servDocente.listar();
        model.addAttribute("listaDocentes", listaDocentes);
        return "listaDocentes";
    }

    @GetMapping("/docentes/formulario")
    public String cargarDocenteModal(Model model){
        DocenteDto docenteLlenar = new DocenteDto();
        model.addAttribute("docenteLlenar", docenteLlenar);
        return "crear";
    }

    @PostMapping("/docentes/nuevo")
    public String crearDocente(DocenteDto docente){
        servDocente.ingresar(docente);
        return "redirect:/docentes/lista";
    }

    @GetMapping("/docentes/{id}")
    public String mostrarDocente(@PathVariable Long id, Model model){
        DocenteDto docente = servDocente.findDtoById(id);
        model.addAttribute("docente", docente);
        return "mostrarDocente";
    }
}
