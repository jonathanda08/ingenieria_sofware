package co.ucentral.gestionador.de.notas.controlador;

import co.ucentral.gestionador.de.notas.dto.EstudiantesDto;
import co.ucentral.gestionador.de.notas.servicios.ServicioEstudiante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControladorEstudiante {


    ServicioEstudiante servEstudiante;

    public ControladorEstudiante(ServicioEstudiante servEstudiante) {
        this.servEstudiante = servEstudiante;
    }

    @GetMapping("/estudiantes/lista")
    public String listarEstudiantes(Model model){
        List<EstudiantesDto> listaEstudiantes = servEstudiante.listar();
        model.addAttribute("listaEstudiantes", listaEstudiantes);
        return "listaEstudiante";
    }

    @GetMapping("/estudiantes/formulario")
    public String cargarEstudianteModal(Model model){
        EstudiantesDto estudianteLlenar = new EstudiantesDto();
        model.addAttribute("estudianteLlenar", estudianteLlenar);
        return "/estudiantes/nuevo";
    }

    @PostMapping("/estudiantes/nuevo")
    public String ingresar(EstudiantesDto estudiante){
        servEstudiante.ingresar(estudiante);
        return "crearEstudainte";
    }

    @GetMapping("/estudiantes/{id}")
    public String mostrarEstudiante(@PathVariable Long id, Model model){
        EstudiantesDto estudiante = servEstudiante.findDtoById(id);
        model.addAttribute("estudiante", estudiante);
        return "mostrarEstudiante";
    }
}